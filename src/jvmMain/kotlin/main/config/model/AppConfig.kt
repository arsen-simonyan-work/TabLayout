package main.config.model

import kotlinx.serialization.Serializable

@Serializable
data class AppConfig(
    val size: Int = -1,
    val text: String = ""
)
