package com.clean.cryptoclean.di

import android.content.Context
import com.clean.cryptoclean.presentation.RootFragment
import com.clean.cryptoclean.presentation.coin_detail.CoinDetailFragment
import com.clean.cryptoclean.presentation.coin_list.dollar.CoinListFragment
import com.clean.cryptoclean.presentation.coin_list.euro.EuroFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(fragment: CoinListFragment)

    fun inject(fragment: CoinDetailFragment)

    fun inject(fragment: RootFragment)

    fun inject(fragment: EuroFragment)

    @Component.Factory
    interface ApplicationComponentBuilder {
        fun create(
            @BindsInstance context: Context,
        ): AppComponent
    }
}