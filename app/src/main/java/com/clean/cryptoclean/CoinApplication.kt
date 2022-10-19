package com.clean.cryptoclean

import android.app.Application
import com.clean.cryptoclean.di.DaggerAppComponent


class CoinApplication : Application(){

    val component by lazy {
       DaggerAppComponent.factory().create(this)
    }
}