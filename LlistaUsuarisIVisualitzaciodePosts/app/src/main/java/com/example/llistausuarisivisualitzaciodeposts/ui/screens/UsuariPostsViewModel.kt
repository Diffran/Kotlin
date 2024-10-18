package com.example.llistausuarisivisualitzaciodeposts.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.llistausuarisivisualitzaciodeposts.LlistaUsuarisApplication
import com.example.llistausuarisivisualitzaciodeposts.data.MainAppRepository
import com.example.llistausuarisivisualitzaciodeposts.model.Usuari
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

//per fer la connexio entre les dades del retrofit i la UI li paso el repositori
class UsuariPostsViewModel(private val repository: MainAppRepository) : ViewModel(){
    private val _usuaris = mutableStateOf<List<Usuari>>(emptyList())
    //exposar la llista dusuaris con un state public
    val usuaris: State<List<Usuari>> = _usuaris

    //crida la funcio i la inicialitza... la de sota
    init{
        getUsuaris()
    }

    private fun getUsuaris(){
        viewModelScope.launch{
            try {
                val llistaUsuaris = repository.getUsuaris()
                _usuaris.value = llistaUsuaris
            }catch(e: IOException){
                //de moment res...
            }catch(e: HttpException){
                //de moment res...
            }

        }
    }
    //La Factory per inicialitzar el singleton del viewModel
    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory{
            initializer{
                val application = (this[APPLICATION_KEY] as LlistaUsuarisApplication)
                val mainAppRepository = application.container.mainAppRepository
                UsuariPostsViewModel(repository = mainAppRepository)
            }
        }
    }
}

