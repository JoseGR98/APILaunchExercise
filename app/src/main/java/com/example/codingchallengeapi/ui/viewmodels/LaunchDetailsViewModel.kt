package com.example.codingchallengeapi.ui.viewmodels

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengeapi.domain.ILaunchDetailsGeneralRepository
import com.example.codingchallengeapi.domain.model.LaunchDetails
import com.example.codingchallengeapi.utils.ResultAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LaunchDetailsViewModel @Inject constructor(private val apiRepository: ILaunchDetailsGeneralRepository) :
    ViewModel() {

    private val _launchDetailsList = MutableLiveData<LaunchDetails>()

    val launchDetailsList: LiveData<LaunchDetails>
        get() = _launchDetailsList

    fun getSpecificList(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = apiRepository.getSpecificResult(id)) {
                is ResultAPI.Error -> {
                    withContext(Dispatchers.Main) {
                        Log.d("ERROR", "Error API Elements")
                    }
                }

                is ResultAPI.Success -> {
                    withContext(Dispatchers.Main) {
                        result.data.let { launchDetails ->
                            _launchDetailsList.postValue(launchDetails)
                        }
                    }
                }
            }
        }
    }

    fun descriptionIsNullOrEmpty(description: String): Boolean {
        return description.isEmpty()
    }

    fun imageIsNullOrEmpty(image: Drawable?): Boolean {
        return image != null
    }

}
