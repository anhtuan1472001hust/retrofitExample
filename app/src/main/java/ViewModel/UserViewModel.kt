package ViewModel

import Respository.UserRepository
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vnpt.retrofitexample.MainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import network.Users
import utils.Resources
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private lateinit var composite: CompositeDisposable
    private var listUsers = MutableLiveData<List<Users>>()
    val _users : LiveData<List<Users>>
    get()=listUsers

    private fun getCurrentUser() {
        composite.add(
            userRepository.getCurrentUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listUsers = it
                },{

                })
        )
                }
    override fun onCleared() {
        super.onCleared()
        composite.dispose()
    }


    }

