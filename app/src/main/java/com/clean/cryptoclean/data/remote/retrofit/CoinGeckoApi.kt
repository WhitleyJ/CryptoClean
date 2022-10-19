package com.clean.cryptoclean.data.remote.retrofit

import com.clean.cryptoclean.data.remote.dto.details.CoinDetailDto
import com.clean.cryptoclean.data.remote.dto.list.euro.CoinEuroDto
import com.clean.cryptoclean.data.remote.dto.list.euro.CoinEuroDtoItem
import com.clean.cryptoclean.data.remote.dto.list.usd.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinGeckoApi {
    @GET("api/v3/coins/markets?vs_currency=usd&order=market_cap" +
            "_desc&per_page=70&page=1&sparkline=false&price_change_percentage=1h")
    suspend fun getAllCoins(): CoinDto

    @GET("api/v3/coins/markets?vs_currency=eur&order=market_cap" +
            "_desc&per_page=70&page=1&sparkline=false&price_change_percentage=1h")
    suspend fun getEuroCoins(): CoinEuroDto

    @GET("api/v3/coins/{id}")
    suspend fun getCoinById(@Path("id")id:String): CoinDetailDto

}