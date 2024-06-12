package com.nj.pruebacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class basicsActivity :
    ComponentActivity() { //Por si hay confusion, la clase se debe llamar igual que el archivo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            mainFunction() //Main function en reemplazo a las lineas de codigo principales
        }
    }
}

@Preview
@Composable
private fun mainFunction() { //Funcion principal

    var counter by rememberSaveable { mutableStateOf(0) } //Contador tipo state para la cantidad de likes. rememberSaveable permite guardar los likes incluso despues de cambiar la orientacion del dispositivo

    LazyColumn( //LazyColumn (Reemplazo de Recycler view o Scroll View)
        modifier = Modifier //Modificador para la plantilla
            .fillMaxSize() //Que ocupe to-do el espacio de la apliacion
            .background(Color.Cyan) //De fondo, un color cyan
    ) {
        item {//Se debe de crear un item para las lazycolumns, dentro del item va to-do lo que va a contener esta lazy column
            Image(
                //Imagen
                modifier = Modifier //Tambien el modifier es como el que asigna las configuraciones a cada cosa
                    .fillMaxWidth() //Que la imagen llene to-do el ancho
                    .height(400.dp), //Y de alto, 400dp
                painter = painterResource(id = R.drawable.logo_banana), //De donde se va a sacar la imagen
                contentDescription = "Logo Banana", //Texto alterno
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {//Row donde iran los likes y la cantidad
                Image( //Imagen del corazon del like
                    painter = painterResource(id = R.drawable.baseline_favorite_24),
                    contentDescription = "Favoritos",
                    modifier = Modifier.clickable { counter++ } //clickable lo vuelve un objeto que ejecuta una accion al hacer click, la cual sera aumentar en 1 el contador de likes
                )

                Text(
                    text = counter.toString(), //El texto sera ahora el contador, pasado a string
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp) //Padding basico
                )
            }
            Text( //Ingresamos un texto
                text = "Hola, Nicolas", //Texto como tal
                fontSize = 32.sp, //Tamaño del texto
                color = Color.White, //Color del texto
                modifier = Modifier.fillMaxWidth(), //Modificador de que llene to-do el ancho
                textAlign = TextAlign.Center //Para luego, alinearlo al centro de la pantalla
            )
            Text(
                text = "Texto de prueba de parrafo",
                color = Color.White
            ) //Otro texto con color blanco
            Text(
                text = "Segundo texto de prueba",
                color = Color.White
            ) //Otro texto con color blanco
            LazyRow( //LazyRow permite una fila (horizontal) fuera de la aplicacion, pudiendo deslizar a la izquierda o derecha dependiendo
                horizontalArrangement = Arrangement.SpaceBetween, //Se le da una configuracion horizontal para que cada item este separado en misma cantidad de distancia
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) //Que ocupe el maximo de ancho, pero con separacion de 16dp a la izquierda y derecha
            ) {
                item {//Item, ya que los objetos tipo "Lazy" necesitan un item
                    Text(
                        text = "Hola soy Yo",
                        color = Color.White
                    ) //Textos para comprobar que funcione bien
                    Text(text = "Hola soy Yo", color = Color.White)
                    Text(text = "Hola soy Yo", color = Color.White)
                    Text(text = "Hola soy Yo", color = Color.White)
                    Text(text = "Hola soy Yo", color = Color.White)
                    Text(text = "Hola soy Yo", color = Color.White)
                    Text(text = "Hola soy Yo", color = Color.White)
                    Text(text = "Hola soy Yo", color = Color.White)
                }
            }
        }

    }
}