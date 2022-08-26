// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.biel.DateTransformation
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import javax.xml.crypto.Data


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Calculo de Data") {

        Scaffold (
            topBar = {TopAppBar(title = { Text(text = "Calculo de Datas Apenas") },


                )}

        )
        {
            Row (
                horizontalArrangement =  Arrangement.Center,
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            )
            {}
            Column  (
            )
            {

            }
        }

        textFieldInsere()

        botaoCalcula("Calcule a Data")

    }
}

@Composable
fun textFieldInsere() {
    var textoData by remember { mutableStateOf("") }

    MaterialTheme {
        run {
            //COMEÇO DA ROW DO TEXFIELD DE DATA!
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {

            }
            //COMEÇO DA COLUMN DO TEXFIELD DE DATA!
            Column(
                modifier = Modifier.fillMaxSize().fillMaxHeight().offset(y = -120.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            )
            {
                val maxChar = 8
                TextField(

                    value = textoData,
                    onValueChange = {
                        if (it.length <= maxChar) textoData = it
                        try {
                            
                        }
                        catch (e: Exception) {

                        }
                    },
                    visualTransformation = DateTransformation(),
                    label = {
                        Text(text = "Data")
                    },
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    leadingIcon = {
                        IconButton(onClick = {
                        }) {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "DateRange Icon"
                            )
                        }
                    },
                    )
            }
            //COMEÇO DA ROW DO TEXFIELD DE DATA!
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {}
            //COMEÇO DA COLUMN DO TEXFIELD DE DATA!
            Column(
                modifier = Modifier.fillMaxSize().fillMaxHeight().offset(y = -40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            )
            {
                TextField(
                    value = "A diferença de dias entre a data inserida e a data de hoje é de ${entre(textoData)} dias ",
                    onValueChange = {
                    },

                    readOnly = true,
                            )
            }
            Column (
                    ) {
            }
        }
    }
}



fun converte(calculaData: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("ddMMyyyy")
    return LocalDate.parse(calculaData, formatter)
}

fun entre(dataStr: String): String {
    if (dataStr.length < 8 ) {
        return "Por favor"
    }
    try {
        val data1 = converte(dataStr)
        val data2 = LocalDate.now()
        val maxChar = 8
        return ChronoUnit.DAYS.between(data1, data2).toString()
    }
    catch (e: Exception) {
        return "Data Invalida $dataStr"
    }


}

@Composable
fun botaoCalcula(text: String) {

    var calculo by remember { mutableStateOf(false) }
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().offset(y = 100.dp).offset(x = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Button(onClick = {
                calculo = !calculo
            },
            )
            {
                Text("Calcule a Data Inserida aqui!")
                darkColors(Color.Blue)
                Spacer(modifier = Modifier.height(16.dp))
                Modifier.offset(y = 400.dp).offset(x = 130.dp)
                Alignment.CenterHorizontally
                Arrangement.Center
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Modifier.offset(y = 600.dp).offset(x = 130.dp)
        Alignment.CenterHorizontally
        Arrangement.Center



        AnimatedVisibility(calculo) {
            boxAparece()
            Modifier.offset(y = 600.dp).offset(x = 130.dp)
            Alignment.CenterHorizontally
            Arrangement.Center
        }

    }

}

//                    BOX APARECERÁ APÓS O CLIQUE DO USUARIO
@Composable
fun boxAparece() {

    var formatter = SimpleDateFormat("d/M/yyyy")
    val formatterr = DateTimeFormatter.ofPattern("d/M/yyyy")
//    var formatado = DateTimeFormatter.ofPattern(textoInserido.toString(), formatterr.locale)

    MaterialTheme {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {

        }
        Box(
            contentAlignment = Alignment.Center,

            modifier = Modifier.offset(y = 460.dp).offset(x = 700.dp)

                .background(Color.LightGray)
                .height(50.dp)
                .clip(CircleShape)
                .width(500.dp)
                .shadow(20.dp)
                .fillMaxSize()
        ) {
            Text(
                "a diferença entre as datas é }",
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}




//@Composable
//fun DescendantExample() {
//    // CompositionLocalProviders also work across composable functions
//    Text("This Text uses the disabled alpha now")
//}




//fun CompositionLocalExample() {
//    MaterialTheme { // MaterialTheme sets ContentAlpha.high as default
//        Column {
////            Text("Uses MaterialTheme's provided alpha")
////            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
////                Text("Medium value provided for LocalContentAlpha")
////                Text("This Text also uses the medium value")
//
//            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
//            textFieldInsere()
//            }
//        }
//    }
//}


