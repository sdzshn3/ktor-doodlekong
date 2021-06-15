package com.sdzsn3.data.models

import com.sdzsn3.data.Room
import com.sdzsn3.other.Constants.TYPE_PHASE_CHANGE

data class PhaseChange(
    var phase: Room.Phase?,
    var time: Long,
    val drawingPLayer: String? = null
): BaseModel(TYPE_PHASE_CHANGE)
