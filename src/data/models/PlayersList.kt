package com.sdzsn3.data.models

import com.sdzsn3.data.Player
import com.sdzsn3.other.Constants.TYPE_PLAYERS_LIST

data class PlayersList(
    val players: List<PlayerData>
): BaseModel(TYPE_PLAYERS_LIST)
