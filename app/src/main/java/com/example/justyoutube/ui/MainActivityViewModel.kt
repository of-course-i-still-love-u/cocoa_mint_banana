package com.example.justyoutube.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justyoutube.apiService.ApiPortal
import com.example.justyoutube.model.BaseApiResponse
import com.example.justyoutube.model.Youtube
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {

    val myResponse:MutableLiveData<BaseApiResponse<MutableList<Youtube>>> = MutableLiveData()

    fun getYoutubeList(){
        viewModelScope.launch {
            myResponse.value = ApiPortal.retrofit.getYoutubeList()
        }
    }
}