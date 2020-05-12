package com.example.kotlin_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {

    companion object {
        val MOVIE_NAME = "movie_passed"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

//        val  movie = intent.getSerializableExtra(MOVIE_NAME) as Movie
//        textView.text = movie.toString()
        val movie: Movie = intent.getParcelableExtra(MOVIE_NAME) as Movie
        textView.text = movie.toString()
    }
}
