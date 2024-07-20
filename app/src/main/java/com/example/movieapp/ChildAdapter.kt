package com.example.movieapp

import android.content.Context
import android.content.Intent
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
        val childItem = childModelClassList[position]
        holder.ivChildImage.setImageResource(childItem.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieDescriptionActivity::class.java)
            intent.putExtra("imageResId", childItem.image)
            // Add more data as needed
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return childModelClassList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivChildImage: ImageView = itemView.findViewById(R.id.iv_child_item)
    }
}
