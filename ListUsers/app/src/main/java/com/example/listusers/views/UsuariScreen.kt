package com.example.listusers.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.listusers.model.Usuari
import com.example.listusers.viewModel.AppViewModel


//Aqui li paso el viewModel per connectar amb les dades que aquest te del repository
@Composable
fun UsuarisScreen(viewModel : AppViewModel, onUserSelected: (Usuari) -> Unit){
    val usuaris by viewModel.users//li passa la variable publica del llistat amb els usuaris

    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        items(usuaris) { usuari ->
            UsariItemScreen(usuari = usuari, onUserClick = {onUserSelected(usuari)})
        }
    }
}

@Composable
fun UsariItemScreen(usuari : Usuari, onUserClick: () -> Unit){
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation  = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
            .clickable{ onUserClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.AccountCircle,
                contentDescription = "Usuari",
                tint = Color.Black,
                modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = usuari.username ?:"UNKNOWN",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = usuari.name ?: "UNKNOWN",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}