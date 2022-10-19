package com.clean.cryptoclean.domain.use_case

import com.clean.cryptoclean.data.remote.dto.list.euro.toCoin
import com.clean.cryptoclean.domain.model.Coin
import com.clean.cryptoclean.domain.repository.CoinsRepository
import javax.inject.Inject

class GetEuroCoinsUseCase @Inject constructor(private val repository: CoinsRepository) {

    suspend operator fun invoke(): List<Coin> {
        return repository.getEuroCoins().map { it.toCoin() }
    }
}