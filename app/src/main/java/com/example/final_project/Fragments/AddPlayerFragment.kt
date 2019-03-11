package com.example.final_project.Fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.final_project.API.APIservice
import com.example.final_project.BuildConfig
import com.example.final_project.MainActivity
import com.example.final_project.R
import com.example.final_project.players.PlayerData
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.beginfragment_layout.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AddPlayerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beginfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val playerName = input_login.text.toString()
        btn_find.setOnClickListener {

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

            val call = apIservice.getPlayer("CHEEL40000")

            call.enqueue(object : Callback<PlayerData> {


                override fun onFailure(call: Call<PlayerData>, t: Throwable) {
                    Log.d("FAIL", "FAIL что-то не так!")
                    Snackbar.make(it,"Something is wrong",Snackbar.LENGTH_LONG).show()
                }


                override fun onResponse(call: Call<PlayerData>, response: Response<PlayerData>) {
                    Log.d("OK", "Что-то заработало!")
                    val mainActivity = this@AddPlayerFragment.activity as MainActivity
                    mainActivity.changeFragment(
                        MainActivity.LIST_PLAYERS_FRAGMENT,
                        response.body()!!.getName(),
                        response.body()!!.getId())
                }
            })


        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddPlayerFragment().apply {
            }
    }
}
