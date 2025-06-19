package com.example.practicumexam

import android.annotation.SuppressLint


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainScreenActivity : AppCompatActivity() {
    private val playlist = mutableListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen)

        val addToPlaylistButton = findViewById<Button>(R.id.addtoplaylistButton)
        val viewPlaylistButton = findViewById<Button>(R.id.viewplaylistButton)
        val exitButton = findViewById<Button>(R.id.exitappButton)

        addDefaultSongs()

        addToPlaylistButton.setOnClickListener {
            showAddSongDialog()
        }

        viewPlaylistButton.setOnClickListener {
            val intent = Intent(this, ViewScreenActivity::class.java)
            intent.putExtra("playlist", ArrayList(playlist))
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }

    private fun addDefaultSongs() {
        playlist.add(Song("COFFEE BEAN", "Travis Scott", 9.0f, "Smooth Hip-Hop"))
        playlist.add(Song("MR.T", "Westside Gunn", 8.5f, "RAP"))
        playlist.add(Song("DNA", "Earl Sweatshirt", 7.0f, "HIP-HOP"))
        playlist.add(Song("Rehab", "Brent Faiyaz", 10.0f, "R&B"))
        playlist.add(Song("NOT LIKE US", "Kendrick Lamar", 9.0f, "RAP"))
    }

    @SuppressLint("MissingInflatedId")
    private fun showAddSongDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_song, null)
        val titleInput = dialogView.findViewById<TextInputEditText>(R.id.songEditText)
        val artistInput = dialogView.findViewById<TextInputEditText>(R.id.artistEditText)
        val ratingInput = dialogView.findViewById<TextInputEditText>(R.id.ratingEditText)
        val genreInput = dialogView.findViewById<TextInputEditText>(R.id.genreEditText)

        AlertDialog.Builder(this)
            .setTitle("Add com.example.practicumexam.Song to Playlist")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val title = titleInput.text.toString()
                val artist = artistInput.text.toString()
                val rating = ratingInput.text.toString().toFloatOrNull() ?: 0f
                val genre = genreInput.text.toString()

                if (title.isNotEmpty() && artist.isNotEmpty() && genre.isNotEmpty()) {
                    if (rating in 1f..10f) {
                        playlist.add(Song(title, artist, rating, genre))
                        Toast.makeText(this, "com.example.practicumexam.Song added to playlist", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Rating must be between 1 and 10", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}

// com.example.practicumexam.Song.kt

data class Song(
    val title: String,
    val artist: String,
    val rating: Float,
    val genre: String
) : java.io.Serializable
