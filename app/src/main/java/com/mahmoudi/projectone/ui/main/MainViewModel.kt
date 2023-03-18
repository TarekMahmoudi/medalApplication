package com.mahmoudi.projectone.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudi.projectone.data.model.AchievementsResponseModel
import com.mahmoudi.projectone.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _achievementsSuccessLiveData: MutableLiveData<List<AchievementsResponseModel>> = MutableLiveData()
    val achievementsSuccessLiveData: LiveData<List<AchievementsResponseModel>> = _achievementsSuccessLiveData

   private val _achievementsErrorLiveData: MutableLiveData<Exception> = MutableLiveData()
    val achievementsErrorLiveData: LiveData<Exception> = _achievementsErrorLiveData

    private val _achievementsLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val achievementsLoadingLiveData: LiveData<Boolean> = _achievementsLoadingLiveData


    init {
        getAchievement()
    }
            fun getAchievement () {
                viewModelScope.launch {
                    delay(1000)
                    _achievementsLoadingLiveData.postValue(true)
                    try {
                        val response = repository.getAchievements()
                        _achievementsSuccessLiveData.postValue(response)
                    } catch (e:Exception){
                        _achievementsErrorLiveData.postValue(e)
                    }
                    _achievementsLoadingLiveData.postValue(false)



                }
            }
}