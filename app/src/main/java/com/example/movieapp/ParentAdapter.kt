package com.example.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ParentAdapter(
    private val parentModelClassList: List<ParentModelClass>,
    private val context: Context
) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.parent_rv_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvParentTitle.text = parentModelClassList[position].title

        val childAdapter = ChildAdapter(parentModelClassList[position].childModelClassList, context)
        holder.rvChild.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.rvChild.adapter = childAdapter
        childAdapter.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return parentModelClassList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvChild: RecyclerView = itemView.findViewById(R.id.rv_child)
        val tvParentTitle: TextView = itemView.findViewById(R.id.tv_parent_title)
    }
}
