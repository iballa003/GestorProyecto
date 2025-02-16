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
import model.Project

class ProjectDetailScreen(val project: Project) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {navigator?.pop()}){
                    Text(text = "Volver")
                }
                Text(text = "Detalles del Proyecto", fontSize = 24.sp, modifier = Modifier.padding(start = 8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Nombre: ${project.nombre}", fontSize = 18.sp, modifier = Modifier.padding(top = 8.dp))
            Text(text = "Descripción: ${project.descripcion}", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
            Text(text = "Fecha creación: ${project.fecha_creacion}", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
            Text(text = "Fecha inicio: ${project.fecha_inicio}", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
            Text(text = "Fecha finalización: ${project.fecha_finalizacion}", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navigator?.push(TasksScreen(project)) },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text(text = "Ver Tareas del Proyecto")
            }
        }
}
}