package com.justin.publisher

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.justin.publisher.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        val db = Firebase.firestore

        FirebaseAuth.getInstance()

//        binding.goToPublish.setOnClickListener {
//            this.findNavController().navigate(MainActivityDirections.actionMainActivityToPublishArticlePage()
//            )
        }


        fun addData() {
            val articles = FirebaseFirestore.getInstance()
                .collection("articles")
            // Create a new user with a first, middle, and last name
            val data = hashMapOf(
                "author" to hashMapOf(
                    "email" to "wayne@school.appworks.tw",
                    "id" to "waynechen323",
                    "name" to "AKA小安老師"
                ),
                "title" to "IU「亂穿」竟美出新境界!笑稱自己品味奇怪 網笑:靠顏值撐住女神氣場",
                "content" to "南韓歌手IU(李知恩)無論在歌唱方面或是近期的戲劇作品都有亮眼的成績，但俗話說人無完美、美玉微瑕，曾再跟工作人員的互動影片中坦言自己 品味很奇怪，近日在IG上分享了宛如「媽媽們青春時代的玉女歌手」超復古穿搭造型，卻意外美出新境界。",
                "createdTime" to Calendar.getInstance()
                    .timeInMillis,
//                "id" to document.id,
                "category" to "Beauty"
            )
//            document.set(data)

        }
    }
}