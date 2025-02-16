package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.Project
import model.User
import network.getFinishedProjects
import network.getProjects

class ProyectsScreen(val user: User, val finished : Boolean) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val proyectsList = remember { mutableStateOf(emptyList<Project>()) }
        if(finished) {
            getFinishedProjects{
                proyectsList.value = it
            }
        }else{
            getProjects {
                proyectsList.value = it
            }
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

                Text(text = "Lista de Proyectos", fontSize = 24.sp, modifier = Modifier.padding(8.dp))
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(proyectsList.value) { project ->
                    ProjectItem(project, {})
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project, onProjectClick: (Project) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable { onProjectClick(project) },
        //elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = project.nombre, fontSize = 20.sp)
            Text(text = project.descripcion, fontSize = 14.sp, modifier = Modifier.padding(top = 4.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onProjectClick(project) }) {
                Text(text = "Más Información")
            }
        }
    }
}


