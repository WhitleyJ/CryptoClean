package com.clean.cryptoclean.presentation.coin_list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.clean.cryptoclean.R
import com.clean.cryptoclean.databinding.CoinItemBinding
import com.clean.cryptoclean.domain.model.Coin

class ListCoinAdapter : RecyclerView.Adapter<ListCoinAdapter.ListViewHolder>() {
    var coinList = emptyList<Coin>()

    lateinit var onItemClick: ((Coin) -> Unit)

    class ListViewHolder(val binding: CoinItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = CoinItemBinding.inflate(LayoutInflater.from(parent.context
        ), parent, false)
        return ListViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val itemUsd = coinList[position]
        with(holder.binding) {
            root.setOnClickListener {
                onItemClick.invoke(itemUsd)
            }
            Glide.with(root.context).load(itemUsd.image).centerCrop().placeholder(R.drawable.img)
                .into(imageItemCoin)
            nameCryptoItemCoin.text = itemUsd.name
            symbolCryptoItemCoin.text = itemUsd.symbol
            priceCoinTextItem.text = "${itemUsd.current_price}"
            stockQuotesItemCoin.text = if (itemUsd.price_change_percentage_24h > 0) {
                stockQuotesItemCoin.setTextColor(ContextCompat.getColor(root.context,
                    R.color.green))
                "+${itemUsd.price_change_percentage_24h}% "
            } else {
                stockQuotesItemCoin.setTextColor(ContextCompat.getColor(root.context, R.color.red))
                "-${itemUsd.price_change_percentage_24h}%"
            }
        }
    }

    fun setData(list: List<Coin>) {
        val callback = CoinDiffCallback(coinList, list)
        val result = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)
        coinList = list
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
}

