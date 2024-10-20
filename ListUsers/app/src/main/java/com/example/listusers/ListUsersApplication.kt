package com.example.listusers

import android.app.Application
import com.example.listusers.data.AppRepository
import com.example.listusers.data.AppRepositoryImpl
import com.example.listusers.data.network.RetrofitServiceFactory


class ListUsersApplication : Application(){
    lateinit var repository: AppRepository

    override fun onCreate(){
        super.onCreate()

        val retrofitService = RetrofitServiceFactory.makeRetrofitService()
        repository = AppRepositoryImpl(retrofitService)
    }
}