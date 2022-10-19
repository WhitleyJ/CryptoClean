package com.clean.cryptoclean.presentation.coin_list.euro

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.clean.cryptoclean.CoinApplication
import com.clean.cryptoclean.databinding.FragmentCoinListBinding
import com.clean.cryptoclean.databinding.FragmentEuroBinding
import com.clean.cryptoclean.di.CoinViewModelFactory
import com.clean.cryptoclean.presentation.coin_list.ListCoinAdapter
import com.clean.cryptoclean.presentation.coin_list.dollar.CoinListFragment.Companion.launchDetailFragment
import javax.inject.Inject


class EuroFragment : Fragment() {

    private var adapterRc = ListCoinAdapter()

    @Inject
    lateinit var viewModelFactory: CoinViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinEuroViewModel::class.java]
    }

    private val binding by lazy {
        FragmentEuroBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (requireActivity().application as CoinApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        initViewModel()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }


    private fun initViewModel() {
        viewModel.coinsEuro.observe(viewLifecycleOwner) {
            if (it != null) {
                adapterRc.setData(it)
            }
        }
    }

    private fun initRecyclerView() {
        binding.rcView.apply {
            adapter = adapterRc
            layoutManager = LinearLayoutManager(requireActivity(),
                LinearLayoutManager.VERTICAL, false)
        }
        adapterRc.onItemClick = { launchDetailFragment(it.id) }
    }

}