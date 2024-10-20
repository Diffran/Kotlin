package com.example.listusers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.listusers.ui.theme.ListUsersTheme
import com.example.listusers.viewModel.AppViewModel
import com.example.listusers.viewModel.AppViewModelFactory
import com.example.listusers.views.HomeScreen

class MainActivity : ComponentActivity() {
    //OJO
    private lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = application as ListUsersApplication
        val factory = AppViewModelFactory(app.repository)
        viewModel = ViewModelProvider(this, factory).get(AppViewModel::class.java)

        setContent {
            ListUsersTheme {
                HomeScreen(viewModel)
            }
        }
    }
}



