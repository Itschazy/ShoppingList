package com.chxzyfps.shoppinglist.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chxzyfps.shoppinglist.R
import com.chxzyfps.shoppinglist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var count = 0

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d("ShopListAdapter", "onCreateViewHolder count: ${++count}")

        val layout = when (viewType) {
            ENABLED_VIEWTYPE -> R.layout.item_shop_enabled
            DISABLED_VIEWTYPE -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown ViewType: $viewType")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()
        viewHolder.view.setOnLongClickListener {
            true
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (shopList[position].enabled) ENABLED_VIEWTYPE else DISABLED_VIEWTYPE
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    companion object {
        const val ENABLED_VIEWTYPE = 1
        const val DISABLED_VIEWTYPE = 2

        const val MAX_POOL_SIZE = 15
    }

}