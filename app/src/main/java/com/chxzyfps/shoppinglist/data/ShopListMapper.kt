package com.chxzyfps.shoppinglist.data

import com.chxzyfps.shoppinglist.domain.ShopItem
import javax.inject.Inject

class ShopListMapper @Inject constructor() {

    fun mapEntityToDbModel(shopitem: ShopItem): ShopItemDbModel {
        return ShopItemDbModel(
            id = shopitem.id,
            name = shopitem.name,
            count = shopitem.count,
            enabled = shopitem.enabled
        )
    }

    fun mapDbModelToEntity(shopItemDbModel: ShopItemDbModel) : ShopItem{
        return ShopItem(
            id = shopItemDbModel.id,
            name = shopItemDbModel.name,
            count = shopItemDbModel.count,
            enabled = shopItemDbModel.enabled
        )
    }

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) : List<ShopItem> {
        return list.map {
            mapDbModelToEntity(it)
        }
    }

}