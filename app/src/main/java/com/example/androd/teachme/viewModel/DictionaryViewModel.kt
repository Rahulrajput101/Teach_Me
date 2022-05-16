package com.example.androd.teachme.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androd.teachme.networking.DictionaryApi
import com.example.androd.teachme.networking.dictionaryApiService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class DictionaryViewModel(application: Application) : AndroidViewModel(application) {

    private val _response= MutableLiveData<String>()
    val response:LiveData<String>
        get() {
             return _response
        }
    init {

        getDictionaryWords()
    }

    fun getDictionaryWords() {
        DictionaryApi.retrofitService.getProperties().enqueue(object: retrofit2.Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
               _response.value=response.body()!!
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value="failure" + t.message

            }

        })

    }
}