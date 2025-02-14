package model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val usuario: String,
    val passwd: String
)
