package network

import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import utils.sha512
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import model.LoginRequest
import model.User
import network.NetworkUtils.httpClient


fun ApiLogIn(user:String, password:String, onSuccessResponse: (User) -> Unit){
    var url = "http://127.0.0.1:5000/login"
    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.post(url){
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(user, sha512(password)))
        }
        if(response.status == HttpStatusCode.OK){
            val user = response.body<User>()
            onSuccessResponse(user)
        }else{
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}