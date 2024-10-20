package com.example.listusers.data.network

import com.example.listusers.data.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceFactory{
    fun makeRetrofitService() : RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)

    }
}