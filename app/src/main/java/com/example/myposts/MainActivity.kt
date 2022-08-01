package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }
    fun fetchPosts(){   //call back functions
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPosts()

        request.enqueue(object : Callback<List<Post>> {   //transfer request to another thread
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext,"fetched ${posts!!.size} post",Toast.LENGTH_LONG).show()
                    var displayPostsRvAdapter = displayPostsRvAdapter(baseContext,posts)
                    binding.rvDisplay.layoutManager = LinearLayoutManager(baseContext)
                    binding.rvDisplay.adapter = displayPostsRvAdapter
                }


            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

        })
    }
}