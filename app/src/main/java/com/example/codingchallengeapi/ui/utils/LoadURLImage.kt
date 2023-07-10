package com.example.codingchallengeapi.ui.utils

import android.widget.ImageView
import com.example.codingchallengeapi.R
import com.squareup.picasso.Picasso

object LoadURLImage {
    fun ImageView.loadFromURL(imageURL: String) {
        if (imageURL.isNotBlank() && imageURL != "") {
            Picasso.get().load(imageURL).into(this)
        } else {
            this.setImageResource(R.drawable.no_image)
        }
    }
}

// TODO - Let approach