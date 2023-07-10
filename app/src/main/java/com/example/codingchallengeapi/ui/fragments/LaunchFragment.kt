package com.example.codingchallengeapi.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.codingchallengeapi.databinding.FragmentLaunchBinding
import com.example.codingchallengeapi.ui.viewmodels.LaunchViewModel
import com.example.codingchallengeapi.ui.RecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchFragment : Fragment() {
    private lateinit var binding: FragmentLaunchBinding
    private val viewModel: LaunchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLaunchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        val recyclerViewAdapter = RecyclerViewAdapter()
        { selectedItem ->
            val action = LaunchFragmentDirections.actionLaunchFragmentToLaunchDetailsFragment(
                selectedItem.id
            )
            findNavController().navigate(action)
        }
        recyclerView.adapter = recyclerViewAdapter

        viewModel.launchList.observe(viewLifecycleOwner) {
            recyclerViewAdapter.submitList(it)
        }
    }

}
