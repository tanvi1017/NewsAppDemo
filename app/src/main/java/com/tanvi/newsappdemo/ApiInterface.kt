package com.tanvi.newsappdemo

import com.tanvi.newsappdemo.Model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    // https://newsapi.org/v2/everything?q=sports&ApiKey=vvgv
    @GET("top-headlines") // hedlin
    fun getTopNews(
        @Query("Country") Country:String?,
        @Query("Apikey")ApiKey:String?,
        @Query("Pagesize") Pagesize:Int,
    ): Call<NewsModel>

    @GET("everything")//spor.....yha pr 3 parameters hai, q apikey and paeg size
    fun getNews(
        @Query("q")q:String?,
        @Query("ApiKey")ApiKey: String?,
        @Query("pagesize")pagesize:Int

    ):Call<NewsModel>

}