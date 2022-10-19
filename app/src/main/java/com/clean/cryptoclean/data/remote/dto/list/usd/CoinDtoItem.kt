package com.clean.cryptoclean.data.remote.dto.list.usd

import com.clean.cryptoclean.domain.model.Coin

data class CoinDtoItem(
    val id: String,
    val current_price: Double,
    val image: String,
    val name: String,
    val price_change_percentage_24h: Double,
    val symbol: String
)

fun CoinDtoItem.toCoin(): Coin {
    return Coin(
        id = id,
        current_price = current_price,
        image = image,
        name = name,
        price_change_percentage_24h = price_change_percentage_24h,
        symbol = symbol
    )
}