import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(bottom = 18.dp),
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
                modifier = Modifier.padding(top = 20.dp)
            )
            TextField(value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.padding(top = 20.dp)
            )
            Button(
                onClick = {},
                modifier = Modifier.padding(top = 20.dp)
            ){
                Text(text = "Login")
            }
        }
//        Button(onClick = {
//            text = "Hello, Desktop!"
//        }) {
//            Text(text)
//        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
