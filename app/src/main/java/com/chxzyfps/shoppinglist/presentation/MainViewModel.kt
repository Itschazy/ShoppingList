package com.chxzyfps.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.chxzyfps.shoppinglist.data.ShopListRepositoryImpl
import com.chxzyfps.shoppinglist.domain.DeleteShopItemUseCase
import com.chxzyfps.shoppinglist.domain.EditShopItemUseCase
import com.chxzyfps.shoppinglist.domain.GetShopListUseCase
import com.chxzyfps.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }
}