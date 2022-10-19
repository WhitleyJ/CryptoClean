package com.clean.cryptoclean.domain.use_case

import com.clean.cryptoclean.data.remote.dto.details.toCoinDetail
import com.clean.cryptoclean.domain.model.CoinDetail
import com.clean.cryptoclean.domain.repository.CoinsRepository
import javax.inject.Inject

class GetCoinUsdUseCase @Inject constructor(private val repository: CoinsRepository) {
    suspend operator fun invoke(coinId: String): CoinDetail {
        return repository.getCoinById(coinId).toCoinDetail()
    }
}