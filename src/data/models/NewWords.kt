package com.sdzsn3.data.models

import com.sdzsn3.other.Constants.TYPE_NEW_WORDS

data class NewWords(
    val newWords: List<String>
): BaseModel(TYPE_NEW_WORDS)
