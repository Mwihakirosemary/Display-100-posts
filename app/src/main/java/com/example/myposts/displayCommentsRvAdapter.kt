package com.example.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.CommentsListItemBinding
import com.example.myposts.databinding.PostListItemBinding

class displayCommentsRvAdapter(var commentList: List<Comment>):
RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding = CommentsListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment =commentList.get(position)
        with(holder.binding){
            tvPostIdHolder.text = currentComment.postId.toString()
            tvId2.text = currentComment.id.toString()
            tvNameHolder.text = currentComment.name
            tvEmailHolder.text = currentComment.email
            tvBodyHolder.text = currentComment.body

        }

    }


    override fun getItemCount(): Int {
        return commentList.size
    }
}
class CommentsViewHolder(var binding: CommentsListItemBinding): RecyclerView.ViewHolder(binding.root)
