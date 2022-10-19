package com.clean.cryptoclean.domain.model

import com.clean.cryptoclean.data.remote.dto.details.*

data class CoinDetail(
    val id: String,
    val image: Image,
    val name: String,
    val symbol: String,
    val description: Description,
)
