package com.example.kotlin_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var movie = Movie("Captain America", 9)

//        val movieList: ArrayList<Movie> = ArrayList();
//        movieList.add(Movie("Iron Man", 7))
//        movieList.add(Movie("The Incredible Hulk", 6));
//        movieList.add(Movie("Iron Man 2", 7));
//        movieList.add(Movie("Thor", 8));
//        movieList.add(Movie("The Avengers", 9));
//        movieList.add(Movie("Iron Man 3", 8));
//        movieList.add(Movie("Thor: The Dark World", 8));
//        movieList.add(Movie("Captain America: The Winter Soldier", 10));
//        movieList.add(Movie("Guardians of the Galaxy", 8));
//        movieList.add(Movie("Avengers: Age of Ultron", 10));

        var movieList = arrayListOf<Movie>(
            Movie("Iron Man", 7),
            Movie("The Incredible Hulk", 6),
            Movie("Iron Man 2", 7),
            Movie("Thor", 8),
            Movie("The Avengers", 9),
            Movie("Iron Man 3", 8),
            Movie("Thor: The Dark World", 8),
            Movie("Captain America: The Winter Soldier", 10),
            Movie("Guardians of the Galaxy", 8),
            Movie("Avengers: Age of Ultron", 10)
        )

        val recyclerAdapter = RecyclerAdapter(movieList, this)
//        recyclerView.adapter = recyclerAdapter
//        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
//        recyclerView.setHasFixedSize(true)
        recyclerView.apply {
            adapter = recyclerAdapter
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            setHasFixedSize(true)
        }
    }

    override fun onClick(position: Int) {
        Toast.makeText(this, "onClick $position", Toast.LENGTH_LONG).show()
    }

    override fun onLongClick(position: Int) {
        Toast.makeText(this, "onLongClick $position", Toast.LENGTH_LONG).show()
    }
}
