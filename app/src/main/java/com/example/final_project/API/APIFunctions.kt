package com.example.final_project.API

import android.util.Log
import com.example.final_project.BuildConfig
import com.example.final_project.players.PlayerData
import com.example.final_project.players.SeasonStatsData
import com.example.final_project.players.SeasonsData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public fun getPlayer(name: String, callback: (PlayerData) -> Unit) {
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
            Log.d("OK", "Игрок получен!")
            //TODO( вот тут мы можем получить: {"errors":[{"title":"Not Found","detail":"No Players Found Matching Criteria"}]})
            // Это надо обработать как "ИГРОК НЕ НАЙДЕН"
            val data = response.body()
            if (data != null) callback.invoke(data)
        }
    })
}

fun getSeasons(platform: String, callback: (SeasonsData) -> Unit) {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl("https://api.pubg.com/shards/$platform/")
        .build()


    val apIservice = retrofit.create(APIservice::class.java)

    val call = apIservice.getSeasons()

    call.enqueue(object : Callback<SeasonsData> {


        override fun onFailure(call: Call<SeasonsData>, t: Throwable) {
            Log.d("FAIL", "FAIL что-то не так!")
        }


        override fun onResponse(call: Call<SeasonsData>, response: Response<SeasonsData>) {
            Log.d("OK", "Сезоны получены!")
            //здесь нужно куда-то сохранять список сезонов
            val data = response.body()
            if (data != null) callback.invoke(data)
        }
    })
}

fun getSeasonStats(playerId: String, seasonId: String, callback: (SeasonStatsData) -> Unit) {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl("https://api.pubg.com/shards/pc-ru/players/$playerId/")
        .build()


    val apIservice = retrofit.create(APIservice::class.java)

    val call = apIservice.getSeasonStats(seasonId)

    call.enqueue(object : Callback<SeasonStatsData> {


        override fun onFailure(call: Call<SeasonStatsData>, t: Throwable) {
            Log.d("FAIL", "FAIL что-то не так!")
        }


        override fun onResponse(call: Call<SeasonStatsData>, response: Response<SeasonStatsData>) {
            Log.d("OK", "Статистика за сезон получена!")
            //здесь нужно запускать функцию, которая отобразит статистику в StatFragment
            val data = response.body()
            if (data != null) callback.invoke(data)
        }
    })
}
