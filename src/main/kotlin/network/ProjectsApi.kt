package network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.Project
import network.NetworkUtils.httpClient

fun getProjects(onSuccessResponse: (List<Project>) -> Unit) {
    val url = "http://127.0.0.1:5000/proyecto/proyectos_activos"

    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
        }
        if (response.status == HttpStatusCode.OK) {
            val listProyecto = response.body<List<Project>>()
            onSuccessResponse(listProyecto)
        } else {
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}