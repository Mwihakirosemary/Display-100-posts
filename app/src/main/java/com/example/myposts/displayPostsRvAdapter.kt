package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostListItemBinding

class displayPostsRvAdapter(var context: Context, var displayPost: List<Post>) :
RecyclerView.Adapter<RetrofitviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitviewHolder {
        var binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitviewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitviewHolder, position: Int) {
        var currentPosts =displayPost.get(position)
        with(holder.binding){
            tvUserId.text = currentPosts.userId.toString()
            tvId.text = currentPosts.id.toString()
            tvTitle.text = currentPosts.title
            tvBody.text = currentPosts.body
            val context = holder.itemView.context
            holder.binding.cvPost.setOnClickListener{
                val intent = Intent(context,CommentsActivity::class.java)
                intent.putExtra("POST_ID",currentPosts.id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return displayPost.size
    }
}
class RetrofitviewHolder(val binding: PostListItemBinding): RecyclerView.ViewHolder(binding.root)