package com.example.listusers.data

import com.example.listusers.model.Post
import com.example.listusers.model.Usuari

interface AppRepository {
    suspend fun getAllUsers(): List<Usuari>
    suspend fun getUserPosts(userId: Int): List<Post>
}

class AppRepositoryImpl(private val retrofitService: RetrofitService): AppRepository {
    override suspend fun getAllUsers(): List<Usuari> {
        return retrofitService.getAllUsers()
    }

    override suspend fun getUserPosts(userId: Int): List<Post> {
        return retrofitService.getUserPosts(userId)
    }

}