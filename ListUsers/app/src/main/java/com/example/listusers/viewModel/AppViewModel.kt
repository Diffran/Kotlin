package com.example.listusers.viewModel



import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.listusers.data.AppRepository
import com.example.listusers.model.Post
import com.example.listusers.model.Usuari
import kotlinx.coroutines.launch
import java.io.IOException

class AppViewModel(private val repository: AppRepository) : ViewModel() {
    //llista Ususaris
    private val _users = mutableStateOf<List<Usuari>>(emptyList())
    val users: State<List<Usuari>> = _users

    //llista Posts
    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts

    init{
        getAllUsersViewModel()
    }

    private fun getAllUsersViewModel(){
        viewModelScope.launch{
            try{

                val fetchedUsers = repository.getAllUsers()
                _users.value = fetchedUsers

            }catch(e : IOException){
                //TODO: de moment res
            }
        }
    }

    fun onUserSelected(user : Usuari){
        viewModelScope.launch{
            try{
                val fetchedPosts = repository.getUserPosts(user.id ?:0)
                _posts.value = fetchedPosts

            }catch(e : IOException){
                //TODO<: de moment res
            }
        }
    }
}

//ex.3 crear la factory del viewModel
class AppViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            return AppViewModel(repository) as T
        }
        throw IllegalArgumentException("Error en el viewModel Factory")
    }
}