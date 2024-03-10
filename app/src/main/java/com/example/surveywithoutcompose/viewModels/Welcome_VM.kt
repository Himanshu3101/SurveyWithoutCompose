package com.example.surveywithoutcompose.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.surveywithoutcompose.data.LoginData
import com.example.surveywithoutcompose.data.Repository
import com.example.surveywithoutcompose.data.UserRequest
import com.example.surveywithoutcompose.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Welcome_VM @Inject constructor(private val repository: Repository, application: Application) : BaseViewModel(application) {

    private val _response: MutableLiveData<NetworkResult<LoginData>> = MutableLiveData()
    val response: LiveData<NetworkResult<LoginData>> = _response

    fun getProductsList(siginData: UserRequest) = viewModelScope.launch {
        repository.getProductList(context, siginData).collect { values ->
            _response.value = values
        }
    }
}