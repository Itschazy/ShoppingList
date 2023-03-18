package com.chxzyfps.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chxzyfps.shoppinglist.domain.ShopItem

@Entity(tableName = "shop_items")
data class ShopItemDbModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean,
)