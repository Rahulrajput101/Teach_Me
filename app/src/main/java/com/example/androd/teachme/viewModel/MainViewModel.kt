package com.example.androd.teachme.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androd.teachme.dataClass.words
import com.google.gson.Gson
import java.io.InputStream

class MainViewModel(application: Application): AndroidViewModel(application) {
    private  var wordList: Array<words>
    private  var index=0

    init {
        wordList= loadWordFromAssets()
    }

    private fun loadWordFromAssets(): Array<words> {
        val inputStream=getApplication<Application>().assets.open("random_words.json")
        val size: Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        //change byte array to String
        val json = String(buffer,Charsets.UTF_8)
        val gson=Gson()
        return gson.fromJson(json,Array<words>::class.java)

    }

    fun getWord()=wordList[index]

    fun randomWord(): words {
        var size=wordList.size
        var random = (0 until size).random()
        return wordList[random]

    }
}