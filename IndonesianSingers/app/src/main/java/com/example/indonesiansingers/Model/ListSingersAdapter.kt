package com.example.indonesiansingers.Model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.indonesiansingers.Data.Singers
import com.example.indonesiansingers.R

class ListSingersAdapter (val listSingers: ArrayList<Singers>) : RecyclerView.Adapter<ListSingersAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_row_singers, p0, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSingers.size
    }

    override fun onBindViewHolder(p0: ListViewHolder, p1: Int) {
        val (name, from, photo) = listSingers[p1]

        Glide.with(p0.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55,55))
            .into(p0.singerPhoto)

        p0.singerName.text = name
        p0.singerFrom.text = from

        p0.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listSingers[p0.adapterPosition]) }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var singerName: TextView = itemView.findViewById(R.id.singers_name)
        var singerFrom: TextView = itemView.findViewById(R.id.singers_from)
        var singerPhoto: ImageView = itemView.findViewById(R.id.singers_photo)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Singers)
    }
}