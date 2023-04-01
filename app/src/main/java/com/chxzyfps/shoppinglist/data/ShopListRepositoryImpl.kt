package com.chxzyfps.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.chxzyfps.shoppinglist.domain.ShopItem
import com.chxzyfps.shoppinglist.domain.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(
    private val shopListDao: ShopListDao,
    private val mapper: ShopListMapper,
) : ShopListRepository {

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopitem(shopItem.id)
    }

    override suspend fun editShopItem(item: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(item))
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem {
        return mapper.mapDbModelToEntity(shopListDao.getShopItem(shopItemId))
    }

    override fun getShopList(): LiveData<List<ShopItem>> =
        Transformations.map(shopListDao.getShopList()) {
            mapper.mapListDbModelToListEntity(it)
        }

}