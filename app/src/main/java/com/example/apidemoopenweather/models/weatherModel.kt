package com.example.apidemoopenweather.models

data class weatherModel(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Forecast3hour>,
    val message: Int
)