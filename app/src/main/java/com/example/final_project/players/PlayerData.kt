package com.example.final_project.players

import com.google.gson.annotations.SerializedName

data class PlayerData(
    @SerializedName("data")
    //хоть тут и лист, но заказываем мы одного игрока по имени,
    //так приходится делать, т.к. апи подразумевает запрос
    //списка имен, иначе получить id игрока нельзя :(
    //id нужен уже для всех остальных запросов
    val player: List<Player>
)

data class Player(
    val id: String,
    @SerializedName("attributes")
    val attributes: PlayerAttributes
)

data class PlayerAttributes(
    val name: String
)
