package com.chxzyfps.shoppinglist.data

import com.chxzyfps.shoppinglist.domain.ShopItem
import com.chxzyfps.shoppinglist.domain.ShopItem.Companion.UNDEFINED_ID
import com.chxzyfps.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(item: ShopItem) {
        val oldItem = getShopItem(item.id)
        shopList.remove(oldItem)
        addShopItem(item)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw java.lang.RuntimeException("Item with $shopItemId was not found.")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

}