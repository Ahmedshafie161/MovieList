package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.network.Movie

class CustomAdapter(private var myList: ArrayList<Movie>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.addData(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun updateList(myList: ArrayList<Movie>) {
        this.myList = myList
        notifyDataSetChanged()
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        // inflate views
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val tvName: TextView = view.findViewById(R.id.tv_name)

        //add data to views
        fun addData(movie: Movie) {
            tvName.text = movie.Title
            Glide.with(view)
                .load(movie.Poster)
                .override(300, 200)
                .into(imageView)
        }

    }


}