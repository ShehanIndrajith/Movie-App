package com.example.movieapp

data class Actor(val name: String, val imageResId: Int)

object Data {
    fun getActors(): List<Actor> {
        return listOf(
            Actor("Actor 1", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            Actor("Actor 2", R.drawable.actor),
            // Add more items
        )
    }
}