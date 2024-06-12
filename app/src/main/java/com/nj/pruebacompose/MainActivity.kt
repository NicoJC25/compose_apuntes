package com.nj.pruebacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nj.pruebacompose.ui.theme.PruebaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            pruebaComposeApp()
        }
    }
}

//Se puede poner en una funcion el layout principal para ver como van los avances
@Preview(showBackground = true)
@Composable
fun pruebaComposeApp(){
    PruebaComposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

//Funcion propia creada
@Preview(showBackground = true)
@Composable
fun PruebaPersonal(){
        Text(text = "Contagia ese poder", modifier = (Modifier.padding(horizontal = 16.dp)))

}

//Funcion del saludo
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//Funcion para mostrar la del saludo, ya que no se pueden mostrar funciones con datos de entrada
@Preview(showBackground = true, name = "Hola pe")
@Composable
fun GreetingPreview() {
    PruebaComposeTheme {
        Greeting("Android")
    }
}