package com.vnpt.retrofitexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import network.Users

class DataAdapter(private val context : Context,
private val users : List<Users>) :
    RecyclerView.Adapter<DataAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.textTitle)
        val body = itemView.findViewById<TextView>(R.id.textBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        return UserViewHolder(view)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user : Users = users.get(position)
        holder.title.text=user.title
        holder.body.text=user.body
    }
    override fun getItemCount(): Int {
        return users.size
    }

}