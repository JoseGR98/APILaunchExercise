package com.example.codingchallengeapi.utils

import android.widget.ImageView
import com.example.codingchallengeapi.R
import com.squareup.picasso.Picasso

object ImageViewUtils {
    fun ImageView.loadFromURL(url: String) {
        if (url.isNotBlank()) {
            Picasso.get().load(url).into(this)
        } else {
            this.setImageResource(R.drawable.ic_launcher_background)
        }
    }
}