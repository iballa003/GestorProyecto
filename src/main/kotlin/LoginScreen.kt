import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

//@Composable
//fun LoginScreen() {
//    Column(
//        modifier = Modifier.fillMaxSize().padding(bottom = 28.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        var username by remember {
//            mutableStateOf("username")
//        }
//        var password by remember {
//            mutableStateOf("password")
//        }
//        Text(text = "Login", fontWeight = FontWeight.Bold, fontSize = 28.sp)
//        TextField(value = username,
//            onValueChange = { username = it },
//            label = { Text("Username") },
//            modifier = Modifier.padding(top = 30.dp)
//        )
//        TextField(value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier.padding(top = 30.dp)
//        )
//        Button(
//            onClick = {},
//            modifier = Modifier.padding(top = 30.dp)
//        ){
//            Text(text = "Login")
//        }
//    }
//}
class LoginScreen : Screen {
    @Composable
    override fun Content() {
        // Get the navigator
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = 28.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            var username by remember {
                mutableStateOf("username")
            }
            var password by remember {
                mutableStateOf("password")
            }
            Text(text = "Login", fontWeight = FontWeight.Bold, fontSize = 28.sp)
            TextField(value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.padding(top = 30.dp)
            )
            TextField(value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.padding(top = 30.dp)
            )
            Button(
                onClick = {
                    // Navigate to details screen with the arguments
                    navigator?.push(WelcomeScreen())
                },
                modifier = Modifier.padding(top = 30.dp)
            ){
                Text(text = "Login")
            }
    }
}
}