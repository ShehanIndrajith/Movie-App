package com.example.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ChildAdapter(
    private val childModelClassList: List<ChildModelClass>,
    private val context: Context
) : RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.child_rv_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivChildImage.setImageResource(childModelClassList[position].image)
    }

    override fun getItemCount(): Int {
        return childModelClassList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivChildImage: ImageView = itemView.findViewById(R.id.iv_child_item)
    }
}

