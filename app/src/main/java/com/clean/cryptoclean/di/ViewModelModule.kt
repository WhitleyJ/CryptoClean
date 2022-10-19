package com.clean.cryptoclean.di

import androidx.lifecycle.ViewModel
import com.clean.cryptoclean.presentation.coin_detail.CoinDetailViewModel
import com.clean.cryptoclean.presentation.coin_list.dollar.CoinListViewModel
import com.clean.cryptoclean.presentation.coin_list.euro.CoinEuroViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(CoinListViewModel::class)
    @Binds
    fun bindCoinListViewModel(impl: CoinListViewModel): ViewModel

    @IntoMap
    @ViewModelKey(CoinDetailViewModel::class)
    @Binds
    fun bindDetailListViewModel(impl: CoinDetailViewModel): ViewModel


    @IntoMap
    @ViewModelKey(CoinEuroViewModel::class)
    @Binds
    fun bindEuroListViewModel(impl: CoinEuroViewModel): ViewModel


}