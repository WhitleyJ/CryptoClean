package com.clean.cryptoclean.presentation.coin_detail

import com.clean.cryptoclean.domain.model.CoinDetail

data class CoinState (
    val isLoading : Boolean = false,
    val coin : CoinDetail?  = null,
    val isError : String = ""
)