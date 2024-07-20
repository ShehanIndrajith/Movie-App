package com.example.movieapp

import ActorAdapter
import CustomAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class MovieDescriptionActivity : AppCompatActivity() {

    private lateinit var horizontalRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_description)

        val imageView: ImageView = findViewById(R.id.movieposter)
        val imageResId = intent.getIntExtra("imageResId", 0)
        imageView.setImageResource(imageResId)

        val backButton: ImageButton = findViewById(R.id.backarrow)
        backButton.setOnClickListener {
            finish() // This will close the current activity and go back to the previous activity
        }

        val watchNowButton: Button = findViewById(R.id.watchnowbtn)
        watchNowButton.setOnClickListener {
            val intent = Intent(this@MovieDescriptionActivity, MoviePlayerActivity::class.java)
            startActivity(intent)
        }


        // Initialize RecyclerView
        horizontalRecyclerView = findViewById(R.id.horizontal_recycler_view)

        // Set layout manager to horizontal
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.layoutManager = layoutManager

        // Set adapter with data
        val adapter = ActorAdapter(Data.getActors())
        horizontalRecyclerView.adapter = adapter

        val feedbackListView: ListView = findViewById(R.id.feedbacklist)
        val feedbacks = listOf(
            Feedback("User 1", R.drawable.actor, 4, "Great movie!"),
            Feedback("User 2", R.drawable.actor, 5, "I loved it!"),
            Feedback("User 2", R.drawable.actor, 2, "Not good as much"),
            // Add more feedbacks as needed
        )
        val feedadapter = FeedbackAdapter(this, feedbacks)
        feedbackListView.adapter = feedadapter
    }
}
