package com.justin.publisher

import android.R
import android.content.ContentValues.TAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.justin.publisher.databinding.FragmentPublishArticleBinding
import java.util.*

class PublishArticlePage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ): View? {

        val binding = FragmentPublishArticleBinding.inflate(inflater)
        binding.lifecycleOwner = this


        val db = Firebase.firestore

        binding.publishButton.setOnClickListener {

            //加這句是為了使用自動生成的 ID 創建文檔
            val newId = db.collection("articles").document()
//          val id = newId.get()

            val title = binding.inputTitle.text
            val category = binding.inputCategory.text
            val content = binding.inputContent.text

            // Create a new user with a first, middle, and last name
            val articles = hashMapOf(
                "author_id" to "justinyang29@gmail.com",
                "title" to title.toString(),
                "category" to category.toString(),
                "content" to content.toString(),
                //這邊也要加上.id
                "id" to newId.id,
            )
        }
        return binding.root
    }
}