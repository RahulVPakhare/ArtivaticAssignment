package com.artivatic.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artivatic.assignment.R
import com.artivatic.assignment.model.RowsItem
import com.bumptech.glide.Glide

class MainAdapter(private val rows: ArrayList<RowsItem>) :
    RecyclerView.Adapter<MainAdapter.RowViewHolder>() {

    class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        private val image: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(row: RowsItem) {
            row.apply {
                tvTitle.text = title
                tvDescription.text = description
                Glide.with(image.context).load(imageHref).into(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder =
        RowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.bind(rows[position])
    }

    override fun getItemCount(): Int = rows.size

    fun setRows(rows: List<RowsItem>) {
        this.rows.apply {
            clear()
            addAll(rows)
        }
    }
}