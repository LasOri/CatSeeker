package com.emarsys.catseeker.network

import android.util.Log
import com.emarsys.catseeker.model.CatMessageModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    val selinaService: SelinaService by lazy {
        Retrofit.Builder()
                .baseUrl("https://hooks.slack.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SelinaService::class.java)
    }

    fun postCatMessage(message: String) {
        selinaService
                .postCat(CatMessageModel(message))
                .enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        Log.d("CAT", "$response")
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Log.d("CAT", "$t")
                    }
                })
    }
}