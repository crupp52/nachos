package com.crupp52.nachos.ui.list

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.crupp52.nachos.R
import com.crupp52.nachos.data.model.Movie
import kotlinx.android.synthetic.main.movie_list_row.view.*

class MovieListAdapter(
    private val items: List<Movie>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(movie: Movie, itemView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_row, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position], clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie, listener: OnItemClickListener) = with(itemView) {
            title.text = movie.title
            year.text = movie.releaseDate
//            buttonContact.setOnClickListener {
//                // Dial contact number
//                val dialIntent = Intent(Intent.ACTION_DIAL)
//                dialIntent.data = Uri.parse("tel:${people.contact}")
//                itemView.context.startActivity(dialIntent)
//            }

            // RecyclerView on item click
//            setOnClickListener {
//                listener.onItemClick(movie, it)
//            }
        }

    }

}