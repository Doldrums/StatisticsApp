package com.example.final_project.API

import android.util.Log
import com.example.final_project.BuildConfig
import com.example.final_project.players.Player
import com.example.final_project.players.PlayerData
import com.example.final_project.players.SeasonStatistic
import com.example.final_project.players.SeasonsData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIFunctions() {
    //Я не знаю, что тут писать
    //Если этот класс убрать, то куда писать все функции для работы с апи?
    //Прямо во офрагмент?

}


fun listToString(arr: List<String>): String {
    var str = ""
    for (item in arr) str += "$item,"
    str.dropLast(1)
    return str
}

fun getPlayer(name: String) {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl("https://api.pubg.com/shards/steam/")
        .build()


    val apIservice = retrofit.create(APIservice::class.java)

    val call = apIservice.getPlayer(name)

    call.enqueue(object : Callback<PlayerData> {


        override fun onFailure(call: Call<PlayerData>, t: Throwable) {
            Log.d("FAIL", "FAIL что-то не так!")
        }


        override fun onResponse(call: Call<PlayerData>, response: Response<PlayerData>) {
            Log.d("OK", "Что-то заработало!")
            Log.d("pl", response.body()!!.player.last().attributes.name)
            Log.d("pl2", response.body()!!.player.last().id)

            //здесь нужно запускать функцию добавления игрока во фрагменте со списком
        }
    })
}


fun getSeasons() {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl("https://api.pubg.com/shards/steam/")
        .build()


    val apIservice = retrofit.create(APIservice::class.java)

    val call = apIservice.getSeasons()

    call.enqueue(object : Callback<SeasonsData> {


        override fun onFailure(call: Call<SeasonsData>, t: Throwable) {
            Log.d("FAIL", "FAIL что-то не так!")
        }


        override fun onResponse(call: Call<SeasonsData>, response: Response<SeasonsData>) {
            Log.d("OK", "Что-то заработало!")
            //здесь нужно куда-то сохранять список сезонов
        }
    })
}

fun getSeasonStats(name: String,id:String) {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl("https://api.pubg.com/shards/steam/")
        .build()


    val apIservice = retrofit.create(APIservice::class.java)

    val call = apIservice.getSeasonStats(name,id)

    call.enqueue(object : Callback<SeasonStatistic> {


        override fun onFailure(call: Call<SeasonStatistic>, t: Throwable) {
            Log.d("FAIL", "FAIL что-то не так!")
        }


        override fun onResponse(call: Call<SeasonStatistic>, response: Response<SeasonStatistic>) {
            Log.d("OK", "Что-то заработало!")

            //здесь нужно запускать функцию, которая отобразит статистику в StatFragment
        }
    })
}
