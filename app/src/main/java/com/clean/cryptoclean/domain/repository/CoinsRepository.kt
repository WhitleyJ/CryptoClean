package com.clean.cryptoclean.domain.repository

import com.clean.cryptoclean.data.remote.dto.details.CoinDetailDto
import com.clean.cryptoclean.data.remote.dto.list.euro.CoinEuroDto
import com.clean.cryptoclean.data.remote.dto.list.usd.CoinDto

interface CoinsRepository {

    suspend fun getCoins(): CoinDto

    suspend fun getEuroCoins(): CoinEuroDto

    suspend fun getCoinById(coinId: String): CoinDetailDto
}