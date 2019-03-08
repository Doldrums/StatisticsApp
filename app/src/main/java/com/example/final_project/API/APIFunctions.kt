package com.example.final_project.API

import android.content.Context
import android.util.Log
import com.example.final_project.BuildConfig
import com.example.final_project.players.Data
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIFunctions(context: Context)

fun listToString(arr: List<String>): String {
    var str = ""
    for (item in arr) {
        str += "$item,"
    }
    str.dropLast(1)
    return str
}

fun getPlayers(names:List<String>){
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

    val call = apIservice.getPlayers(listToString(names))

    call.enqueue(object : Callback<Data> {
        override fun onFailure(call: Call<Data>, t: Throwable) {
            //Toast.makeText(applicationContext, "FAIL что-то не так!", Toast.LENGTH_SHORT).show()

            Log.d("FAIL", "FAIL что-то не так!")
        }

        override fun onResponse(call: Call<Data>, response: Response<Data>) {
            //Toast.makeText(applicationContext, "Что-то заработало!", Toast.LENGTH_SHORT).show()
            Log.d("OK", "Что-то заработало!")
            val data = response.body()
            for(item in data!!.players){
                Log.d("PLAYER_ID",item.id)
                Log.d("PLAYER_NAME",item.attributes.name)
            }
        }
    })
}