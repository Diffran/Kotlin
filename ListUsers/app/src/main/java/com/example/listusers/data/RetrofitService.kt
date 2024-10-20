package com.example.listusers.data

import com.example.listusers.model.Post
import com.example.listusers.model.Usuari
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("users")
    suspend fun getAllUsers(): List<Usuari>

    @GET("posts")
    suspend fun getUserPosts(@Query("userId") userId: Int): List<Post>
}

