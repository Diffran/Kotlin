package com.example.llistausuarisivisualitzaciodeposts.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.llistausuarisivisualitzaciodeposts.ui.screens.UsuariPostsViewModel
import com.example.llistausuarisivisualitzaciodeposts.ui.screens.UsuarisScreen

/*
* també te parametere de viewModel perque es el que li pasa al Screen
* Aixo es crida a la classe Application per crear el viewModel amb una Factory ja que no es
* pot crear directament
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralScreen(viewModel : UsuariPostsViewModel) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center

                ){ Text("Llistat Usuaris", color = Color.White) }},
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            UsuarisScreen(viewModel = viewModel)
        }

    }
}