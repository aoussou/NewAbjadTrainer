package com.talisol.newabjadtrainer

import android.util.Log
import androidx.compose.foundation.layout.*
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
import com.talisol.newabjadtrainer.DataExamples.wordList

@Composable
fun SetLayoutTrainer() {

    val sessionRunList = remember{DataExamples.wordList.shuffled()}
    var ind = remember{0}
    var questionWord by remember{ mutableStateOf(sessionRunList[ind]) }
    var correctAbjadValue = getAbjadValue(questionWord).toString()
    var guessAbjadValue by remember{ mutableStateOf("") }
    var answerCorrectness by remember{mutableStateOf("")}
    var correctAnswerDisplay by remember{mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.5f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround) {
        Box(){Text(questionWord)}

        OutlinedTextField(
            value = guessAbjadValue,
            onValueChange = {String -> guessAbjadValue = String},
            label = { Text("Input value",textAlign = TextAlign.Center) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        Text(text = correctAnswerDisplay)
        Button(onClick = {correctAnswerDisplay = correctAbjadValue}) {
            Text(text = "show answer")
        }

        Text(text = answerCorrectness)

        Text(text=ind.toString())

        Button(onClick = {answerCorrectness = checkAnswer(correctAbjadValue,guessAbjadValue)}){
            Text(text = "CHECK ANSWER")
        }

        Button(onClick = {
            -> ind += 1;
            for (e in sessionRunList){
            Log.i("INDEX", e)};
//            ind = ind0;
            questionWord = sessionRunList[ind]
            answerCorrectness = "";
            guessAbjadValue = "";
            correctAnswerDisplay = ""
        }) { Text(text = "NEXT" )}
    }
}


fun checkAnswer(realValue: String,userValue:String): String {
    if(realValue == userValue){
        return "correct"}
    else {
        return "FALSE!"
    }

}

fun getWordShuffledList(): List<String>{

    val shuffledList = DataExamples.wordList.shuffled()

    return shuffledList
}
@Composable
@Preview(showBackground = true)
fun DefaultPreviewTrainer() {
    SetLayoutTrainer()
}