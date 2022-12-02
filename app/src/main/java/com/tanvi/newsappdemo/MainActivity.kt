package com.tanvi.newsappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tanvi.newsappdemo.Model.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var news:NewsModel?=null
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        // after the app starts we will call api
        callApiToLoadNews()
    }

    private fun callApiToLoadNews() {
        // create an api interface
        val apiInterface = ApiClient.apiClient.create(ApiInterface::class.java)
        val call: Call<NewsModel> = apiInterface.getNews("science","1073b5e6fe274d00a0a68b5bc44e8bb2",20)
        
        call.enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                if (response.isSuccessful) {
                    news = response.body()
                    SetAdapter()
                } else {

                }
            }
            override fun onFailure(call: Call<NewsModel>, t: Throwable) {}
        })
    }
    private fun SetAdapter() {
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = news?.let { NewsAdapter(it.articles) }
        recyclerView.adapter = adapter

    }
}