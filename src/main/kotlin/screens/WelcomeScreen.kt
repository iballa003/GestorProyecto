package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.User

//@Composable
//fun WelcomeScreen() {
//    Text(text = "Welcome")
//}
class WelcomeScreen(val user: User) : Screen {
    @Composable
    override fun Content() {
        // Get the navigator
        val navigator = LocalNavigator.current
        Column {
            Text(text = "Bienvenido "+user.nombre)
            Row {
                Button(onClick = {
                    navigator?.push(ProyectsScreen(user))
                }){
                    Text(text = "Mostrar proyectos")
                }
                Button(onClick = {

                }){
                    Text(text = "Historial")
                }
                Button(onClick = {
                    navigator?.pop()
                }){
                    Text(text = "Cerrar sesión")
                }
            }
        }
    }
}