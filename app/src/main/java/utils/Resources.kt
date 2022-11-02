package utils

data class Resources<out T>(val state : State,val data : T? ,val message : String?) {
    companion object{
        fun <T> Success(data: T?) :Resources<T>{
            return Resources(State.SUCCESS,data,null)
        }
        fun <T> Loading(data:T?) :Resources<T>{
            return Resources(State.LOADING,data,null)
        }
        fun <T> Error(data:T?,message: String) : Resources<T>{
            return Resources(State.ERROR,data,message)
        }
    }

}