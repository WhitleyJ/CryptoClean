package com.clean.cryptoclean.presentation.coin_list.dollar

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clean.cryptoclean.CoinApplication
import com.clean.cryptoclean.R
import com.clean.cryptoclean.common.Constants
import com.clean.cryptoclean.common.Constants.MAIN
import com.clean.cryptoclean.databinding.FragmentCoinListBinding
import com.clean.cryptoclean.di.CoinViewModelFactory
import com.clean.cryptoclean.presentation.coin_detail.CoinDetailFragment
import com.clean.cryptoclean.presentation.coin_list.ListCoinAdapter
import com.clean.cryptoclean.presentation.coin_list.euro.EuroFragment
import javax.inject.Inject


class CoinListFragment : Fragment() {

    private var adapterRc = ListCoinAdapter()

    @Inject
    lateinit var viewModelFactory: CoinViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinListViewModel::class.java]
    }

    private val binding by lazy {
        FragmentCoinListBinding.inflate(layoutInflater)
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
        viewModel.coins.observe(viewLifecycleOwner) {
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

    companion object {
        fun launchDetailFragment(id: String) {
            val bundle = Bundle()
            bundle.putString("Current_id",id)
            MAIN.navController.navigate(R.id.action_rootFragment_to_coinDetailFragment,bundle)
        }
    }

}