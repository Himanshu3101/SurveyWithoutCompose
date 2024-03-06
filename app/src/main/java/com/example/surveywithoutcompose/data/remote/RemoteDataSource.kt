package com.example.surveywithoutcompose.data.remote

import com.example.surveywithoutcompose.data.UserRequest
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getProducts(sigIn_Data: UserRequest) = apiService.LogIn(sigIn_Data)
}