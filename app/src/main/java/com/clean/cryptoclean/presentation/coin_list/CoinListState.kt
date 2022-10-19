package com.clean.cryptoclean.presentation.coin_list

import com.clean.cryptoclean.domain.model.Coin

data class CoinListState (
    val isLoading : Boolean = false,
    var coins : List<Coin> = emptyList(),
    val isError : String = ""
)