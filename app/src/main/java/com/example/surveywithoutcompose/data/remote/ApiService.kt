package com.example.surveywithoutcompose.data.remote

import com.example.surveywithoutcompose.data.LoginData
import com.example.surveywithoutcompose.data.UserRequest
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers(
        "X-Parse-Application-Id:XxFVamR86kFOUSSWnIBZowHJyN2qeFCp4FFotaP5",
        "X-Parse-REST-API-Key:yoi7RByTHZZbBVvSEzCl8waDULT2nN450KGeGaKH",
        "X-Parse-Revocable-Session: 1",
        "Content-Type: application/json"
    )
    @POST("/users")
    suspend fun Sign(@Body jsonObject: JsonObject): Response<LoginData/*ApiResponseData*/>

    @Headers(
        "X-Parse-Application-Id:XxFVamR86kFOUSSWnIBZowHJyN2qeFCp4FFotaP5",
        "X-Parse-REST-API-Key:yoi7RByTHZZbBVvSEzCl8waDULT2nN450KGeGaKH",
        "X-Parse-Revocable-Session: 1"
    )
    @POST("/login")
    suspend fun LogIn(@Body jsonObject: UserRequest): Response<LoginData/*ApiResponseData*/>
}