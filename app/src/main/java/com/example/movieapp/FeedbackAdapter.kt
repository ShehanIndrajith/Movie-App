package com.example.movieapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

data class Feedback(
    val userName: String,
    val userPhotoResId: Int,
    val rating: Int, // Rating from 1 to 5
    val message: String
)

class FeedbackAdapter(context: Context, private val feedbackList: List<Feedback>) : ArrayAdapter<Feedback>(context, 0, feedbackList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val feedback = getItem(position)
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_feedback, parent, false)
        }

        Log.d("FeedbackAdapter", "Binding feedback at position $position")

        val userProfilePhoto: ImageView = view!!.findViewById(R.id.user_profile_photo)
        val userName: TextView = view.findViewById(R.id.user_name)
        val star1: ImageView = view.findViewById(R.id.star1)
        val star2: ImageView = view.findViewById(R.id.star2)
        val star3: ImageView = view.findViewById(R.id.star3)
        val star4: ImageView = view.findViewById(R.id.star4)
        val star5: ImageView = view.findViewById(R.id.star5)
        val feedbackMessage: TextView = view.findViewById(R.id.feedback_message)

        if (feedback != null) {
            Glide.with(context)
                .load(feedback.userPhotoResId)
                .circleCrop()
                .into(userProfilePhoto)

            userName.text = feedback.userName

            // Set star images based on rating
            val stars = listOf(star1, star2, star3, star4, star5)
            for (i in stars.indices) {
                stars[i].setImageResource(
                    when {
                        i + 1 <= feedback.rating -> R.drawable.starfill
                        else -> R.drawable.star
                    }
                )
            }

            feedbackMessage.text = feedback.message
        }

        return view
    }
}
