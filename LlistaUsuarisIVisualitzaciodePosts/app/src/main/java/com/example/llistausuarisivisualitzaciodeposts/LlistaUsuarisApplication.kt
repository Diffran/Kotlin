package com.example.llistausuarisivisualitzaciodeposts

import android.app.Application
import com.example.llistausuarisivisualitzaciodeposts.data.AppContainer
import com.example.llistausuarisivisualitzaciodeposts.data.DefaultAppContainer

//
class LlistaUsuarisApplication : Application() {//aixo ho cridoa el singleton de viewModel
    lateinit var container : AppContainer
    override fun onCreate(){
        super.onCreate()
        container = DefaultAppContainer()
    }
}