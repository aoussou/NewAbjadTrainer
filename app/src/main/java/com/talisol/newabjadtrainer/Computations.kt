package com.talisol.newabjadtrainer

fun getAbjadValue(word:String) :Int {

    val mappingDict = AbjadMapping.map
    var wordValue = 0
    var letterValue = 0

    for (letter in word) {
        letterValue = mappingDict[letter]!!
        wordValue += letterValue
    }

    return wordValue
}


