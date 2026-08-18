package com.example.simpleweatherapp2

data class WeatherResponse(
    val name: String,
    val main: Main,
    val weather:List<Weather>
)

data class Main(
    val temp: Double,
    val humidity: Int
)


data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)