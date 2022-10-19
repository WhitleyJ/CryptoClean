package com.clean.cryptoclean.presentation

import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.clean.cryptoclean.presentation.coin_list.dollar.CoinListFragment
import com.clean.cryptoclean.presentation.coin_list.euro.EuroFragment

class RootViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CoinListFragment()
            else -> {
                EuroFragment()
            }
        }
    }
}