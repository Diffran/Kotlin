package com.example.ciclevida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.ciclevida.ui.CicleVidaScreen
import com.example.ciclevida.viewModel.CicleVidaViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CicleVidaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CicleVidaScreen(viewModel = viewModel)
        }

        viewModel.addEvent("onCreate()")
    }

    override fun onStart() {
        super.onStart()
        viewModel.addEvent("onStart()")
    }

    override fun onResume() {
        super.onResume()
        viewModel.addEvent("onResume()")
    }

    override fun onPause() {
        super.onPause()
        viewModel.addEvent("onPause()")
    }

    override fun onStop() {
        super.onStop()
        viewModel.addEvent("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.addEvent("onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.addEvent("onRestart()")
    }

}

