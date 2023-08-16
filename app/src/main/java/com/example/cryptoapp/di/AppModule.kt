package com.example.cryptoapp.di

import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.data.remote.CoinPapricaApi
import com.example.cryptoapp.data.repository.CoinRepositoryImplementation
import com.example.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {
@Provides
@Singleton
fun providePapricaApi():CoinPapricaApi{
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPapricaApi::class.java)
}

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPapricaApi):CoinRepository{
        return CoinRepositoryImplementation(api)
    }
}