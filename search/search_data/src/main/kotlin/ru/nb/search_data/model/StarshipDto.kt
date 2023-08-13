package ru.nb.search_data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarshipDto(
    @SerialName("name")
    val name: String,

    @SerialName("model")
    val model: String,

    @SerialName("passengers")
    val passengers: String,

    @SerialName("manufacturer")
    val manufacturer: String,

    @SerialName("url")
    val url: String
)