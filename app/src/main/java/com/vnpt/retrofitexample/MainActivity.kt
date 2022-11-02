package com.vnpt.retrofitexample

import ViewModel.UserViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

import network.Users
import retrofit.API
import retrofit.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerview : RecyclerView
    private lateinit var apiServices : ApiServices
    private lateinit var dataAdapter: DataAdapter
    private val viewModel : UserViewModel by viewModels()



    private lateinit  var mDisposable : Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview =findViewById<RecyclerView>(R.id.rclUser)
        connectApi.setOnClickListener(View.OnClickListener {
            setupObserver()
            recyclerview.layoutManager  = LinearLayoutManager(this)
            val divider : DividerItemDecoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
            recyclerview.addItemDecoration(divider)
        })
    }
    private fun setupObserver() {
        viewModel._users.observe(this, {
            dataAdapter = DataAdapter(this,it)
            recyclerview.adapter=dataAdapter
        })
    }
}