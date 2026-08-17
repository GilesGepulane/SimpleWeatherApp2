package com.example.simpleweatherapp2

data class WeatherResponse(
    val name: String,
    val main: Main,
    val weather:List<Weather>
    // TODO: the JSON also contains a "weather" field, which is a LIST of
    // objects, each with a "description". Add that property here.
)

data class Main(
    val temp: Double,
    val humidity: Int    // TODO: the JSON's "main" object also includes humidity.
    // Add the matching property, with the correct type.
)

// TODO: define the data class for each item inside the "weather" list.
// It needs at least one property: description (String).
data class Weather(
    val description: String
)