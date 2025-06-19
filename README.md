# Practicum-Exam
Link to screenshots ![Screenshot 2025-06-19 125047](https://github.com/user-attachments/assets/d0360d28-4396-4e88-be3a-35dfb5804e45)
This Kotlin-based Android app is a Music Playlist Manager that allows users to:

Create and manage a personalized music playlist

Add songs with details (title, artist, rating, genre)

View all songs in a scrollable list

Calculate average ratings of songs in the playlist

Key Features
User-Friendly UI

Clean three-screen flow: Splash → Main → View Playlist

Material Design dialogs for adding songs

Playlist Management

Pre-loaded with 5 default songs (Travis Scott, Kendrick Lamar, etc.)

Add new songs via a form with validation

Serializable data model for passing playlists between activities

Data Display

Lists all songs with title, artist, rating, and genre

Real-time average rating calculation

Technical Highlights

Kotlin with AndroidX components

Reusable Song data class (implements Serializable)

AlertDialog for input (best UX practice)

Intent-based navigation between activities

Why This Project?
✔ Great for learners: Demonstrates basic Android concepts (Activities, Intents, Dialogs, UI Binding)
✔ Modular & scalable: Easy to extend (e.g., add SQLite/Room for persistence)
✔ Production-ready structure: Follows best practices (separation of concerns, clean XML layouts)

How to Run
Clone the repo

Open in Android Studio

Use the Pixel 5 API 33+ emulator (recommended)

Build & run!

Ideal for:

Beginners learning Android (Kotlin)

Developers needing a starter template for playlist apps

Anyone interested in UI/UX best practices for forms and navigation

Future Improvements?

Add SQLite/RecyclerView for better performance

Implement search/sorting

Support music playback
