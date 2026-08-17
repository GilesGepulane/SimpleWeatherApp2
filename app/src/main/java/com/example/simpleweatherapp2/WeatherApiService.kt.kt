package com.example.simpleweatherapp2

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    // TODO: add a @GET annotation with the correct endpoint path
    @GET("data/2.5/weather")
    // (everything after the base URL, before the "?").
    suspend fun getWeather(
        // TODO: add @Query annotations for city, appid, and units.
        @Query("q") city: String,
        @Query("appid") appid: String,
        @Query("units") units: String
        // Match the parameter names exactly to what the API expects.
    ): WeatherResponse
}
