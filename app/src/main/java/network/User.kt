package network

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

private const val TABLE_NAME="user_table"


data class Users(
    @SerializedName("userId")
    var userId : Int,
    @SerializedName("id")
    var id : Int,
    @SerializedName("title")
    var title : String,
    @SerializedName("body")
    var body : String
)