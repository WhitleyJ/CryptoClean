package com.clean.cryptoclean.data.repository

import com.clean.cryptoclean.data.remote.dto.details.CoinDetailDto
import com.clean.cryptoclean.data.remote.dto.list.euro.CoinEuroDto
import com.clean.cryptoclean.data.remote.dto.list.usd.CoinDto
import com.clean.cryptoclean.data.remote.retrofit.CoinGeckoApi
import com.clean.cryptoclean.domain.repository.CoinsRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinGeckoApi
) : CoinsRepository {
    override suspend fun getCoins(): CoinDto {
        return api.getAllCoins()
    }

    override suspend fun getEuroCoins(): CoinEuroDto {
        return api.getEuroCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}