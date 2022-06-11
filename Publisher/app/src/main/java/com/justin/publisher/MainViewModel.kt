package com.justin.publisher

import android.util.Log
import android.util.Log.w
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.logging.Logger

class MainViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

//    fun publishArticle(body: Contact) {
//        coroutineScope.launch {
//            Log.d("Mark", "ContactViewModel coroutineScope postContact()")
//            try {
//                StylishApi.retrofitService.addToContact(body)
//                Log.d("Mark", "POST OK")
//            }catch (e: Exception) {
//                Log.d("Mark", "wrong at postContact()")
            }
//        }
//    }
//}