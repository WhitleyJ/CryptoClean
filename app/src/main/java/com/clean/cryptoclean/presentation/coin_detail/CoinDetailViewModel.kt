package com.clean.cryptoclean.presentation.coin_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean.cryptoclean.domain.model.CoinDetail
import com.clean.cryptoclean.domain.use_case.GetCoinUsdUseCase
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUsdUseCase,
) : ViewModel() {

    val itemList: MutableLiveData<CoinDetail?> = MutableLiveData()

    fun getCoin(id: String) {
        viewModelScope.launch {
            itemList.value = getCoinUseCase(id)
        }
    }
}