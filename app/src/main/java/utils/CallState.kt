package utils

import java.lang.Exception

sealed class CallState<out R>{
    data class Success<out T>(val data : T) : CallState<T>()
    data class Error(val exception : Exception) : CallState<Nothing>()
    object Loading : CallState<Nothing>()
}
