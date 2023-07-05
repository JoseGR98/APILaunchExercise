package com.example.codingchallengeapi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.codingchallengeapi.R
import com.example.codingchallengeapi.domain.model.Launch
import com.example.codingchallengeapi.utils.ImageViewUtils.loadFromURL
import com.example.codingchallengeapi.utils.LaunchDiffUtil

class RecyclerViewAdapter(private val clickListener: (Launch) -> Unit) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val itemList: MutableList<Launch> = mutableListOf()

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)

        fun bind(launch: Launch, clickListener: (Launch) -> Unit) {
            itemView.setOnClickListener {
                clickListener(launch)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.imageView.loadFromURL(currentItem.logo)
        holder.titleTextView.text = currentItem.title
        holder.timeTextView.text = currentItem.time
        holder.bind(currentItem, clickListener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun submitList(list: List<Launch>) {
        val diffResult = DiffUtil.calculateDiff(LaunchDiffUtil(itemList, list))
        itemList.clear()
        itemList.addAll(list)
        //notifyDataSetChanged()
        diffResult.dispatchUpdatesTo(this)
    }

}
