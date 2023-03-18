package com.chxzyfps.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.chxzyfps.shoppinglist.domain.ShopItem
import com.chxzyfps.shoppinglist.domain.ShopItem.Companion.UNDEFINED_ID
import com.chxzyfps.shoppinglist.domain.ShopListRepository

class ShopListRepositoryImpl(application: Application) : ShopListRepository {

    private val shopListDao = AppDatabase.getInstance(application).shopListdao()
    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopitem(shopItem.id)
    }

    override fun editShopItem(item: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(item))
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return mapper.mapDbModelToEntity(shopListDao.getShopItem(shopItemId))
    }

    override fun getShopList(): LiveData<List<ShopItem>> =
        Transformations.map(shopListDao.getShopList()) {
            mapper.mapListDbModelToListEntity(it)
        }

}