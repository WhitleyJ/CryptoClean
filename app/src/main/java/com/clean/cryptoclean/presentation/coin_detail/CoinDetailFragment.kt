package com.clean.cryptoclean.presentation.coin_detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.clean.cryptoclean.CoinApplication
import com.clean.cryptoclean.databinding.FragmentCoinDetailBinding
import com.clean.cryptoclean.di.CoinViewModelFactory
import javax.inject.Inject


class CoinDetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: CoinViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinDetailViewModel::class.java]
    }

    private var _binding: FragmentCoinDetailBinding? = null
    private val binding: FragmentCoinDetailBinding
        get() = _binding ?: throw RuntimeException("CoinListFragmentBinding == null")


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
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
    }

    private fun getArgs() {
        val currentId = arguments?.getString("Current_id")
        viewModel.getCoin(currentId!!)
        viewModel.itemList.observe(viewLifecycleOwner) {
            with(binding) {
                Glide.with(requireActivity()).load(it?.image?.large).centerCrop()
                    .into(imageOfCoin)
                textDescription.text = it?.description?.en
                textCategoryDesc.text = it?.name
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }
}