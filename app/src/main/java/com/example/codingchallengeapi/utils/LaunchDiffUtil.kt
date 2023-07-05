package com.example.codingchallengeapi.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.codingchallengeapi.domain.model.Launch

class LaunchDiffUtil(private val oldList: List<Launch>, private val newList: List<Launch>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}