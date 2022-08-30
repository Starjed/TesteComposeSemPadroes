// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.input.key.Key.Companion.Calendar
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
import java.util.Calendar
import java.util.spi.CalendarDataProvider
import javax.xml.crypto.Data


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Calculo de Data") {

        Scaffold (
//            backgroundColor = Color.Red,
//            modifier = Modifier. border(3.dp, )
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
                    value = "${entre(textoData)}",
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
        return "Por favor, insira uma data válida!"
    }
    else if (dataStr == "26092002") {
        return "Alo, Gabriel?"
    }
    else if (dataStr == "11092003") {
        return "Oii meu amor <3 te amo"
    }
    else if (dataStr == "14062022") {
        return "QUE DATA MARAVILHOSA"
    }
    else if (dataStr == "02092021") {
        return "O MELHOR DIA NAMORAL"
    }
    try {
        val data1 = converte(dataStr)
        val data2 = LocalDate.now()
        val maxChar = 8
        return "A diferença de dias da data inserida até a data de hoje é de " + ChronoUnit.DAYS.between(data1, data2).toString() + " dias"
    }
    catch (e: Exception) {
        return "Data Invalida, não entendi"
    }


}





