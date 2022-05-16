package com.example.androd.teachme.networking


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL="https://mars.udacity.com/"
private val retrofit=Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface dictionaryApiService {
    @GET("realestate")
    fun getProperties(): Call<String>
}
object DictionaryApi{
    val retrofitService : dictionaryApiService by lazy {
        retrofit.create(dictionaryApiService::class.java)
    }
}