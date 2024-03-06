package com.example.surveywithoutcompose.di

import com.example.surveywithoutcompose.MyApplication
import com.example.surveywithoutcompose.data.remote.ApiService
import com.example.surveywithoutcompose.util.Constants.Companion.BASE_URL_GET
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL_GET)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideSurveyAPI(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}