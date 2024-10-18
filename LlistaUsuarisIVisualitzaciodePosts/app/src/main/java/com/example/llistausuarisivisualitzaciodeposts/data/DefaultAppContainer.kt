package com.example.llistausuarisivisualitzaciodeposts.data

import com.example.llistausuarisivisualitzaciodeposts.network.UsuarisPostsServices
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val mainAppRepository: MainAppRepository
}

class DefaultAppContainer : AppContainer{
    private val baseUrl = "https://jsonplaceholder.typicode.com"

    //valors del retrofit
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(Json{ ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
        .build()

    //by lazy va carregant a mesura que la UI ho necessita. Crea el Retrofit
    private val retrofitService: UsuarisPostsServices by lazy {
        retrofit.create(UsuarisPostsServices::class.java)
    }

    //DI implementation per el repository
    override val mainAppRepository : MainAppRepository by lazy {
        NetworkMainAppRepository(retrofitService)
    }
}