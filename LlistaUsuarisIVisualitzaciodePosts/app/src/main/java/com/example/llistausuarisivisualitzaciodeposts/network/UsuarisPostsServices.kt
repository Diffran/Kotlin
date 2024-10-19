package com.example.llistausuarisivisualitzaciodeposts.network

import com.example.llistausuarisivisualitzaciodeposts.model.Posts
import com.example.llistausuarisivisualitzaciodeposts.model.Usuari
import retrofit2.http.GET
import retrofit2.http.Query

interface UsuarisPostsServices{
    @GET("users")
    suspend fun getUsuaris(): List<Usuari>

    @GET("posts")
    suspend fun getPostsdUsuari(@Query("userId") userId : Int) : List<Posts>
}