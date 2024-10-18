package com.example.llistausuarisivisualitzaciodeposts

import android.os.Bundle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.llistausuarisivisualitzaciodeposts.ui.GeneralScreen
import com.example.llistausuarisivisualitzaciodeposts.ui.screens.UsuariPostsViewModel
import com.example.llistausuarisivisualitzaciodeposts.ui.theme.LlistaUsuarisIVisualitzacioDePostsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LlistaUsuarisIVisualitzacioDePostsTheme {
                val viewModel : UsuariPostsViewModel = viewModel(factory = UsuariPostsViewModel.Factory)

                GeneralScreen(viewModel = viewModel)
            }
        }
    }
}

