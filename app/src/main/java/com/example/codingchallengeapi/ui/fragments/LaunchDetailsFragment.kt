package com.example.codingchallengeapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.codingchallengeapi.R
import com.example.codingchallengeapi.databinding.FragmentLaunchDetailsBinding
import com.example.codingchallengeapi.databinding.ItemGalleryBinding
import com.example.codingchallengeapi.ui.viewmodels.LaunchDetailsViewModel
import com.example.codingchallengeapi.utils.ImageViewUtils.loadFromURL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchDetailsFragment : Fragment() {
    private lateinit var binding: FragmentLaunchDetailsBinding
    private val viewModel: LaunchDetailsViewModel by viewModels()
    private val args: LaunchFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_launch_details, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argString = args.idOfLaunch

        viewModel.getSpecificList(argString)
        viewModel.launchDetailsList.observe(viewLifecycleOwner) {
            binding.titleTextView.text = it.title
            binding.subtitleTextView.text = it.time
            binding.titleImageView.loadFromURL(it.logo)
            binding.mainImageView.loadFromURL(it.image.firstOrNull() ?: "")
            binding.descriptionTextView.text = it.details

            it.image.forEach { imageURL ->
                val bindingGalleryItem =
                    ItemGalleryBinding.inflate(layoutInflater, binding.galleryContainer, false)
                bindingGalleryItem.itemImageView.loadFromURL(imageURL)
                binding.galleryContainer.addView(bindingGalleryItem.root)
            }
        }
    }
}
