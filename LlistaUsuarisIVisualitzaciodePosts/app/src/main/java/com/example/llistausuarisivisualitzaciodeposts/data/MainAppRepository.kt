package com.example.llistausuarisivisualitzaciodeposts.data

import com.example.llistausuarisivisualitzaciodeposts.model.Posts
import com.example.llistausuarisivisualitzaciodeposts.model.Usuari
import com.example.llistausuarisivisualitzaciodeposts.network.UsuarisPostsServices

//interfaz amb els metodes del service, sense implementat evidentment
interface MainAppRepository {
    suspend fun getUsuaris() : List<Usuari>
    suspend fun getUsuarisPosts(userId : Int) : List<Posts>
}

/*
 * retorna la interfaz Repository i rep com a parametres el service que utilitza el repository
 * els @GET etc... i override les funcions i les implementa amb un return del service.get/post/etc...
 * que esta implementat en el service
 *
 */
class NetworkMainAppRepository(
    private val usuarisPostsServices: UsuarisPostsServices)
    : MainAppRepository{
    override suspend fun getUsuaris() : List<Usuari> {
        return usuarisPostsServices.getUsuaris()
    }

    override suspend fun getUsuarisPosts(userId : Int) : List<Posts> {
        return usuarisPostsServices.getPostsdUsuari(userId)
    }
}
