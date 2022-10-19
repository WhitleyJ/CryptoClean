package com.clean.cryptoclean.di

import com.clean.cryptoclean.common.Constants
import com.clean.cryptoclean.data.remote.retrofit.CoinGeckoApi
import com.clean.cryptoclean.data.repository.CoinRepositoryImpl
import com.clean.cryptoclean.domain.repository.CoinsRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface DataModule {

    companion object {

        @Provides
        @ApplicationScope
        fun providePaprikaApi(): CoinGeckoApi {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinGeckoApi::class.java)
        }

        @Provides
        @ApplicationScope
        fun provideCoinRepository(api: CoinGeckoApi): CoinsRepository {
            return CoinRepositoryImpl(api)
        }
    }


}