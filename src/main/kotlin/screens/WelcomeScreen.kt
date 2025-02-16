package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "¡Hola, ${user.nombre}!", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {navigator?.push(ProyectsScreen(user, false))}, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Text(text = "Ver Proyectos")
            }

            Button(onClick = {navigator?.push(ProyectsScreen(user, true))}, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Text(text = "Proyectos Terminados")
            }

            Button(onClick = { navigator?.pop() }, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Text(text = "Desconectarse")
            }
        }
    }
}