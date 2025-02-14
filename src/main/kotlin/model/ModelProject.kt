package model

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val fecha_creacion: String,
    val fecha_inicio: String,
    val fecha_finalizacion: String?,
    val cliente: Int
)