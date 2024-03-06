package com.example.surveywithoutcompose.data

import android.content.Context
import android.util.Log
import com.example.surveywithoutcompose.data.remote.RemoteDataSource
import com.example.surveywithoutcompose.data.remote.toResultFlow
import com.example.surveywithoutcompose.util.NetworkResult
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getProductList(context: Context, sigIn_Data: UserRequest): Flow<NetworkResult<LoginData>> {
        return toResultFlow(context){
            remoteDataSource.getProducts(sigIn_Data)
        }
    }
}
