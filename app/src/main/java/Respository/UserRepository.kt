package Respository


import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import network.Users

interface UserRepository {
    fun getCurrentUser() : Observable<MutableLiveData<List<Users>>>
}