package com.example.limonadamaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.limonadamaker.ui.theme.LimonadaMakerTheme
import androidx.compose.foundation.layout.Arrangement.Vertical
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LimonadaMakerTheme {
                LemonadeApp()
            }
        }
    }
}

//la logica de l'app
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(){
    //crear las variables
    var currentStep by remember { mutableStateOf(1) }
    var squeze by remember { mutableStateOf(0) }

    Scaffold(//tot aixo es una especie de plantilla
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.run {
                    largeTopAppBarColors(
                        containerColor = Color(0xFFFFEB3B)
                    )
                }
            )
        }
    ){innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ){
            when(currentStep){
                1 -> {
                    LemonTextAndImage(
                        textLabelId = R.string.tree,
                        drawableId = R.drawable.lemon_tree,
                        contentDescId = R.string.tree_description,
                        onImageClick = {
                            currentStep = 2
                            squeze = (2..4).random()
                        }
                    )
                }
                2 -> {
                    LemonTextAndImage(
                        textLabelId = R.string.lemon,
                        drawableId = R.drawable.lemon_squeeze,
                        contentDescId = R.string.lemon_description,
                        onImageClick = {
                            squeze--
                            if(squeze == 0){
                                currentStep = 3
                            }
                        }
                    )
                }
                3 -> {
                    LemonTextAndImage(
                        textLabelId = R.string.lemonade,
                        drawableId = R.drawable.lemon_drink,
                        contentDescId = R.string.lemonade_descriprion,
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }
                4 -> {
                    LemonTextAndImage(
                        textLabelId = R.string.glass,
                        drawableId = R.drawable.lemon_restart,
                        contentDescId = R.string.glass_description,
                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }


    }

}


// Esta función Composable crea un contenedor que muestra una imagen y un texto.
// La imagen se puede hacer clic y se define un comportamiento a través del parámetro onImageClick.
// La función usa un Box para apilar los elementos y un Column para organizarlos verticalmente,
// centrando tanto el botón de imagen como el texto en la pantalla.
@Composable
fun LemonTextAndImage(
    textLabelId: Int,
    drawableId: Int,
    contentDescId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier){
    Box (modifier = modifier)
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB2E6B2))
            ){
                Image(
                   painter = painterResource(drawableId),
                    contentDescription = stringResource(contentDescId),
                    modifier = Modifier
                        .width(128.dp)
                        .height(160.dp)
                        .padding(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(textLabelId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    LimonadaMakerTheme{
        LemonadeApp()
    }
}

