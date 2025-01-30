import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

//@Composable
//fun WelcomeScreen() {
//    Text(text = "Welcome")
//}
class WelcomeScreen : Screen {
    @Composable
    override fun Content() {
        // Get the navigator
        val navigator = LocalNavigator.current
        Column {
            Text(text = "Welcome Iballa")
            Row {
                Button(onClick = {
                    navigator?.push(ProyectsScreen())
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