package com.talisol.newabjadtrainer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import java.lang.reflect.TypeVariable

@Composable
fun SetLayoutCalculator() {

    var word by remember{ mutableStateOf("") }
    var wordAbjadValue by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.5f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        OutlinedTextField(
            value = word,
            onValueChange = {String -> word = String; wordAbjadValue = getAbjadValue(String).toString() },
            label = { Text("Input word",textAlign = TextAlign.Center) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        Text(wordAbjadValue)

        DisplayAbjadLetter(word)
    }
}

@Composable
fun DisplayAbjadLetter(word: String){

    val mappingDict = AbjadMapping.map

    Row(horizontalArrangement = Arrangement.SpaceEvenly,
    modifier = Modifier.fillMaxWidth()){

        for (letter in word){

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(letter.toString())
                Text(mappingDict[letter].toString())
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreviewCalculator() {

    SetLayoutCalculator()

}