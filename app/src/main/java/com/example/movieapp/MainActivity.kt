package com.example.movieapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var isHomeActive = false
    private var isSearchActive = false
    private var isSaveActive = false
    private var isChatActive = false
    private var isPremiumActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Apply window insets listener to adjust view padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val homeBtn: ImageButton = findViewById(R.id.homebtn)
        val searchBtn: ImageButton = findViewById(R.id.search_button)
        val saveBtn: ImageButton = findViewById(R.id.saveitem_button)
        val chatBtn: ImageButton = findViewById(R.id.msg_button)
        val PremiumBtn: ImageButton = findViewById(R.id.premium_button)
        homeBtn.setOnClickListener {
            animateButton(homeBtn)
            if (!isHomeActive) {
                homeBtn.setImageResource(R.drawable.home) // Ensure this drawable exists
                searchBtn.setImageResource(R.drawable.search)
                saveBtn.setImageResource(R.drawable.bookmark)
                chatBtn.setImageResource(R.drawable.chat)
                PremiumBtn.setImageResource(R.drawable.crown)
                isHomeActive = true
            } else {
                //homeBtn.setImageResource(R.drawable.home1) // Ensure this drawable exists
                isHomeActive = false
            }
        }

        searchBtn.setOnClickListener{
            animateButton(searchBtn)
            if(!isSearchActive){
                searchBtn.setImageResource(R.drawable.search1)
                homeBtn.setImageResource(R.drawable.home1)
                saveBtn.setImageResource(R.drawable.bookmark)
                chatBtn.setImageResource(R.drawable.chat)
                PremiumBtn.setImageResource(R.drawable.crown)
                isSearchActive = true
            } else {
                //searchBtn.setImageResource(R.drawable.search)
                isSearchActive = false
            }
        }

        saveBtn.setOnClickListener{
            animateButton(saveBtn)
            if(!isSaveActive) {
                saveBtn.setImageResource(R.drawable.bookmark__3_)
                searchBtn.setImageResource(R.drawable.search)
                homeBtn.setImageResource(R.drawable.home1)
                chatBtn.setImageResource(R.drawable.chat)
                PremiumBtn.setImageResource(R.drawable.crown)
                isSaveActive = true
            }else{
                isSaveActive = false
            }

        }

        chatBtn.setOnClickListener{
            animateButton(chatBtn)
            if(!isChatActive) {
                chatBtn.setImageResource(R.drawable.comments)
                saveBtn.setImageResource(R.drawable.bookmark)
                searchBtn.setImageResource(R.drawable.search)
                homeBtn.setImageResource(R.drawable.home1)
                PremiumBtn.setImageResource(R.drawable.crown)
                isChatActive = true
            }else{
                isChatActive = false
            }

        }

        PremiumBtn.setOnClickListener{
            animateButton(PremiumBtn)
            if(!isPremiumActive) {
                PremiumBtn.setImageResource(R.drawable.crown1)
                chatBtn.setImageResource(R.drawable.chat)
                saveBtn.setImageResource(R.drawable.bookmark)
                searchBtn.setImageResource(R.drawable.search)
                homeBtn.setImageResource(R.drawable.home1)
                isPremiumActive = true
            }else{
                isPremiumActive = false
            }

        }
    }

    private fun animateButton(view: View) {
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.2f, 1f)
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.2f, 1f)
        scaleX.duration = 300
        scaleY.duration = 300

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleX, scaleY)
        animatorSet.start()
    }
}
