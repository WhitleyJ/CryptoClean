package com.clean.cryptoclean.presentation.coin_list.euro


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.cryptoclean.domain.model.Coin
import com.clean.cryptoclean.domain.use_case.GetEuroCoinsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class CoinEuroViewModel @Inject constructor(
    private val getEuroCoinsUseCase: GetEuroCoinsUseCase,
) :
    ViewModel() {

    val coinsEuro: MutableLiveData<List<Coin>?> = MutableLiveData()

    init {
        getEuroCoins()
    }

    private fun getEuroCoins() {
        viewModelScope.launch {
            coinsEuro.value = getEuroCoinsUseCase()
        }
    }
}