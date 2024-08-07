package com.example.apidemoopenweather.models

data class Forecast3hour (
    val clouds: Clouds?,
    val dt: Int?,
    val dt_txt: String?,
    val main: Main,
    val pop: Int?,
    val sys: Sys?,
    val visibility: Int?,
    val weather: List<Weather>?,
    val wind: Wind?
)

