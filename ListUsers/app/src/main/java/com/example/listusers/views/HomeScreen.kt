package com.example.listusers.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.listusers.viewModel.AppViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel : AppViewModel) {
    //per navegar entre les pantalles
    var currentScreen by remember {mutableStateOf("usuarisScreen")}

    var topBarTitle by remember {mutableStateOf("Llistat d'Usuaris")}

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(topBarTitle, color = Color.White)
                    }
                },
                navigationIcon = {
                    if(currentScreen == "postsScreen") {
                        IconButton(onClick = {
                            currentScreen = "usuarisScreen"
                            topBarTitle = "Llistat Usuaris"
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Retorno",
                                tint = Color.White
                            )
                        }
                    }else{
                        Icon (
                            imageVector = Icons.Default.Home,
                            contentDescription = "Usuari",
                            tint = Color.White,
                            modifier = Modifier.size(30.dp))
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black)
            )
        }
    ){paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            when (currentScreen){
                "usuarisScreen" -> {
                    UsuarisScreen(viewModel){user ->
                        viewModel.onUserSelected(user)
                        topBarTitle = "Posts de ${user.username}"
                        currentScreen = "postsScreen"
                    }
                }
                "postsScreen" -> {
                    PostsScreen(viewModel){
                        currentScreen = "usuarisScreen"
                    }
                }
            }
        }
    }
}