package screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.User

class ProyectsScreen(user: User) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 28.dp),
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row {  
                Button(onClick = {navigator?.pop()}){
                    Text(text = "Volver")
                }
                Text(text = "Proyectos", fontWeight = FontWeight.Bold, fontSize = 28.sp)
            }
            LazyColumn(){
                item {
                    Text(
                        text = "Item 1",
                        modifier = Modifier.padding(16.dp),
                    )
                }
                item {
                    Text(
                        text = "Item 2",
                        modifier = Modifier.padding(16.dp),
                    )
                }
                item {
                    Text(
                        text = "Item 3",
                        modifier = Modifier.padding(16.dp),
                    )
                }
                item {
                    Text(
                        text = "Item 4",
                        modifier = Modifier.padding(16.dp),
                    )
                }
                item {
                    Text(
                        text = "Item 5",
                        modifier = Modifier.padding(16.dp),
                    )
                }
                item {
                    Text(
                        text = "Item 6",
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
    }
}

