package com.example.kotlin_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter(private var movieList: ArrayList<Movie>, private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    class ViewHolder(itemView: View, onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
//                val snack: String = "Item Postion clciked: $adapterPosition"
//                Snackbar.make(itemView, snack, Snackbar.LENGTH_SHORT).show()
                onItemClickListener.onClick(adapterPosition)
            }

            itemView.setOnLongClickListener {
                onItemClickListener.onLongClick(adapterPosition)
                return@setOnLongClickListener true
            }

        }

        fun bind(movie: Movie) {
            itemView.movieNameTextView.text = movie.name
            itemView.ratingTextView.text = movie.rating.toString()
        }
    }

    interface OnItemClickListener {
        fun onClick(position: Int)
        fun onLongClick(position: Int)
    }
}