package com.example.simpleweatherapp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val apiKey = "99259fa197df15aec67516dc47e4052a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCityName = findViewById<EditText>(R.id.etCityName)
        val btnGetWeather = findViewById<Button>(R.id.btnGetWeather)
        val tvCityResult = findViewById<TextView>(R.id.tvCityResult)
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val tvHumidity = findViewById<TextView>(R.id.tvHumidity)
        val weatherImageView = findViewById<ImageView>(R.id.imgWeatherIcon)

        btnGetWeather.setOnClickListener {
            val cityName = etCityName.text.toString().trim()

            if (cityName.isEmpty()) {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                try {
                    val response = RetrofitClient.api.getWeather(
                        cityName,
                        apiKey,
                        "metric"
                    )

                    tvCityResult.text = response.name
                    tvTemperature.text = "${response.main.temp} °C"
                    tvDescription.text = response.weather[0].description
                    tvHumidity.text = "Humidity: ${response.main.humidity}%"

                    val iconCode = response.weather[0].icon

                    val iconUrl = "https://openweathermap.org" + "/img/wn/" + iconCode + "@2x.png"

                    Glide.with(this@MainActivity)
                        .load(iconUrl)
                        .into(weatherImageView)

                } catch (e: Exception) {
                    Toast.makeText(
                        this@MainActivity,
                        "Unable to get weather. Please check the city name or your internet connection.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
