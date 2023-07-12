package com.example.codingchallengeapi.ui.utils

import android.widget.ImageView
import com.example.codingchallengeapi.R
import com.squareup.picasso.Picasso

object LoadURLImage {
    fun ImageView.loadFromURL(imageURL: String) {
        imageURL.takeIf { it.isNotBlank() && it != "" }?.let { nonEmptyURL ->
            Picasso.get().load(nonEmptyURL).into(this)
        } ?: this.setImageResource(R.drawable.no_image)
    }
}
