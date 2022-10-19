package com.clean.cryptoclean.data.remote.dto.details

import com.clean.cryptoclean.domain.model.CoinDetail

data class CoinDetailDto(
    val id: String,
    val image: Image,
    val name: String,
    val symbol: String,
    val description: Description,
)

fun CoinDetailDto.toCoinDetail(): CoinDetail{
    return CoinDetail(
        id = id,
        image = image,
        name = name,
        symbol = symbol,
        description = description
    )
}