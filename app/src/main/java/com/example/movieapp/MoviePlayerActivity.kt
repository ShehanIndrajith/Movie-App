package com.example.movieapp

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MoviePlayerActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var playButton: ImageButton
    private lateinit var pauseButton: ImageButton
    private lateinit var seekBar: SeekBar
    private val handler = Handler()
    private var currentPosition: Int = 0
    private var isPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_player)

        videoView = findViewById(R.id.videoView)
        playButton = findViewById(R.id.play_button)
        pauseButton = findViewById(R.id.pause_button)
        seekBar = findViewById(R.id.seekBar)

        savedInstanceState?.let {
            currentPosition = it.getInt("currentPosition", 0)
            isPlaying = it.getBoolean("isPlaying", false)
        }

        // Sample video URL
        val videoUrl = "https://www.imdb.com/video/vi4161979929/?listId=ls053181649&ref_=ext_shr_lnk"
        videoView.setVideoURI(Uri.parse(videoUrl))

        playButton.setOnClickListener {
            videoView.start()
            playButton.visibility = View.GONE
            pauseButton.visibility = View.VISIBLE
            updateSeekBar()
        }

        pauseButton.setOnClickListener {
            videoView.pause()
            playButton.visibility = View.VISIBLE
            pauseButton.visibility = View.GONE
        }

        videoView.setOnPreparedListener { mp ->
            seekBar.max = videoView.duration
            videoView.seekTo(currentPosition)
            if (isPlaying) {
                videoView.start()
                playButton.visibility = View.GONE
                pauseButton.visibility = View.VISIBLE
            }
            updateSeekBar()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    videoView.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // No-op
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // No-op
            }
        })

        videoView.setOnCompletionListener {
            playButton.visibility = View.VISIBLE
            pauseButton.visibility = View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        currentPosition = videoView.currentPosition
        isPlaying = videoView.isPlaying
        outState.putInt("currentPosition", currentPosition)
        outState.putBoolean("isPlaying", isPlaying)
    }

    private fun updateSeekBar() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                seekBar.progress = videoView.currentPosition
                if (videoView.isPlaying) {
                    handler.postDelayed(this, 1000)
                }
            }
        }, 1000)
    }
}
