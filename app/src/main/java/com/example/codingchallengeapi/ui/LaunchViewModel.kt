package com.example.codingchallengeapi.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingchallengeapi.domain.ILaunchGeneralRepository
import com.example.codingchallengeapi.domain.Launch
import com.example.codingchallengeapi.utils.ResultAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(private val apiRepository: ILaunchGeneralRepository) :
    ViewModel() {

    private val _launchList = MutableLiveData<List<Launch>>()

    val launchList: LiveData<List<Launch>>
        get() = _launchList

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = apiRepository.getResult()) {
                is ResultAPI.Error -> {
                    withContext(Dispatchers.Main) {
                        Log.d("ERROR", "Error API Elements")
                    }
                }

                is ResultAPI.Success -> {
                    withContext(Dispatchers.Main) {
                        result.data.let { launches ->
                            _launchList.value = launches

                            //Example with observable in action
//                            delay(2_000)
//                            _launchList.value = launches.filter {
//                                it.title.contains("at").not()
//                            }
                        }
                    }
                }
            }
        }
    }
}
