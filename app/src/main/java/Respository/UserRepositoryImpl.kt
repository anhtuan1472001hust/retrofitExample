package Respository

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Observable
import network.Users
import retrofit.ApiServices
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiServices : ApiServices) : UserRepository {
    override fun getCurrentUser(): Observable<MutableLiveData<List<Users>>>{
        return apiServices.getUser()
    }
}