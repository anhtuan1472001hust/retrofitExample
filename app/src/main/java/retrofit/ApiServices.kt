package retrofit

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Observable
import network.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("posts")
    fun getUser() : Observable<MutableLiveData<List<Users>>>
}