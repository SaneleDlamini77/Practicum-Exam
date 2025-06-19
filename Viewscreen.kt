package com.example.practicumexam

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class ViewScreenActivity : AppCompatActivity() {
    private lateinit var playlist: List<Song>
    private lateinit var songsTextView: TextView
    private lateinit var averageRatingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewscreen)

        playlist = intent.getSerializableExtra("playlist") as? ArrayList<Song> ?: emptyList()

        songsTextView = findViewById(R.id.SongsTextView)
        averageRatingTextView = findViewById(R.id.ratingTextView)

        val showSongsButton = findViewById<Button>(R.id.showsongsButton)
        val calculateAverageButton = findViewById<Button>(R.id.calculateaverageButton)
        val returnButton = findViewById<Button>(R.id.returnButton)

        showSongsButton.setOnClickListener {
            displaySongs()
        }

        calculateAverageButton.setOnClickListener {
            calculateAverageRating()
        }

        returnButton.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displaySongs() {
        if (playlist.isEmpty()) {
            songsTextView.text = "Playlist is empty"
            return
        }

        val songsText = StringBuilder()
        for (song in playlist) {
            songsText.append("""
                Title: ${song.title}
                Artist: ${song.artist}
                Rating: ${song.rating}/10
                Genre: ${song.genre}

            """.trimIndent())
        }
        songsTextView.text = songsText.toString()
    }

    @SuppressLint("SetTextI18n")
    private fun calculateAverageRating() {
        if (playlist.isEmpty()) {
            averageRatingTextView.text = "No songs to calculate average"
            return
        }

        var totalRating = 0f
        for (song in playlist) {
            totalRating += song.rating
        }
        val average = totalRating / playlist.size
        averageRatingTextView.text = "Average Rating: %.1f/10".format(average)
    }
}

