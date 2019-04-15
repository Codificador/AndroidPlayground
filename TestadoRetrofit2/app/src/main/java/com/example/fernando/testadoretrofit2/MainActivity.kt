package com.example.fernando.testadoretrofit2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Usuario(var login: String, var followers: Int)
interface GithubService {
    @GET("codificador")
    fun dados():Call<Usuario>
}


class RetrofitInitializer {
    fun init():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitInitializer().init().create(GithubService::class.java).dados().run {
            enqueue(object : Callback<Usuario?> {
                override fun onFailure(call: Call<Usuario?>, t: Throwable) {}

                override fun onResponse(call: Call<Usuario?>, response: Response<Usuario?>) {
                    Log.d("ok", "" + (response.body() as Usuario).followers)
                }
            })
        }
    }
}
