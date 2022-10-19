package com.clean.cryptoclean.presentation.coin_list.dollar


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.cryptoclean.domain.model.Coin
import com.clean.cryptoclean.domain.use_case.GetCoinsUsdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUsdUseCase) :
    ViewModel() {

    val coins: MutableLiveData<List<Coin>?> = MutableLiveData()

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            coins.value = getCoinsUseCase()
        }
    }
}