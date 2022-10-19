package com.clean.cryptoclean.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.clean.cryptoclean.R
import com.clean.cryptoclean.databinding.FragmentRootBinding
import com.google.android.material.tabs.TabLayoutMediator


class RootFragment : Fragment() {

    private var ctx: Context? = null

    private var _binding: FragmentRootBinding? = null
    private val binding: FragmentRootBinding
        get() = _binding ?: throw RuntimeException("CoinListFragmentBinding == null")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRootBinding.inflate(inflater, container, false)

        with(binding) {
            viewPager.adapter = RootViewPagerAdapter(ctx as FragmentActivity)

            tabLayout.tabIconTint = null
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
                when (pos) {
                    0 -> tab.setIcon(R.drawable.dollar)
                    1 -> tab.setIcon(R.drawable.euro)
                }
            }.attach()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}