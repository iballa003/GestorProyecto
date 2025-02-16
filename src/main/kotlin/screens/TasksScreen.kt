package screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import model.Project
import model.Task
import network.getTasks

class TasksScreen(val project: Project) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
            val tasksList = remember { mutableStateOf(emptyList<Task>()) }
            getTasks(project.id) {
                tasksList.value = it
                }
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Button(onClick = {navigator?.pop()}){
                        Text(text = "Volver")
                    }

                    Text(text = "Lista de Tareas", fontSize = 24.sp, modifier = Modifier.padding(8.dp))
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(tasksList.value) { task ->
                        TaskItem(task, navigator!!)
                    }
                }
            }
        }
    }

@Composable
fun TaskItem(task: Task, navigator: Navigator) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        //elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = task.nombre, fontSize = 20.sp)
            Text(text = task.descripcion, fontSize = 14.sp, modifier = Modifier.padding(top = 4.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { }) {
                Text(text = "Más Información")
            }
        }
    }
}