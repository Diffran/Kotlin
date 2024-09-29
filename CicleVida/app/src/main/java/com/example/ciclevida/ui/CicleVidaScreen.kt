package com.example.ciclevida.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ciclevida.viewModel.CicleVidaViewModel

    @SuppressLint("NotConstructor")
    @Composable
    fun CicleVidaScreen(viewModel: CicleVidaViewModel){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {

            Spacer(modifier = Modifier.height(60.dp))

            Text(text = "Etapes del Cicle de Vida:",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(viewModel.cicleVidaEvents.value) { event ->
                    Text(text = event.etapa,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 2.dp),)
                }
            }

            Button(
                onClick = { viewModel.resetEvents() },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .width(150.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF607D8B))
            ) {
                    Text("RESET")
            }
        }

    }