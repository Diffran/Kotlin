package com.example.listusers.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listusers.model.Post
import com.example.listusers.viewModel.AppViewModel

@Composable
fun PostsScreen(viewModel : AppViewModel, onBack: () -> Unit){
    val posts by viewModel.posts

    LazyColumn(
        modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
    ) {
        items(posts) { post ->
            PostItemScreen(post = post)
        }
    }

}

@Composable
fun PostItemScreen(post : Post){
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = post.title ?: "",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = post.body ?: "No body available",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
    Divider(color = Color.LightGray, thickness = 1.dp)
}