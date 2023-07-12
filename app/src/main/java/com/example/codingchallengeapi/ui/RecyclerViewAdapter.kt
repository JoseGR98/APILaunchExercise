package com.example.codingchallengeapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.codingchallengeapi.databinding.CardViewBinding
import com.example.codingchallengeapi.domain.model.Launch
import com.example.codingchallengeapi.ui.utils.LoadURLImage.loadFromURL
import com.example.codingchallengeapi.ui.utils.RecyclerListDiffUtil

class RecyclerViewAdapter(private val clickListener: (Launch) -> Unit) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private lateinit var binding: CardViewBinding
    private val itemList: MutableList<Launch> = mutableListOf()

    class ViewHolder(binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(launch: Launch, clickListener: (Launch) -> Unit) {
            itemView.setOnClickListener {
                clickListener(launch)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        binding.imageView.loadFromURL(currentItem.logo)
        binding.titleTextView.text = currentItem.title
        binding.timeTextView.text = currentItem.time
        holder.bind(currentItem, clickListener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun submitList(list: List<Launch>) {
        val diffResult = DiffUtil.calculateDiff(RecyclerListDiffUtil(itemList, list))
        itemList.clear()
        itemList.addAll(list)
        //notifyDataSetChanged()
        diffResult.dispatchUpdatesTo(this)
    }

}
