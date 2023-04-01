package com.chxzyfps.shoppinglist.di

import android.app.Application
import com.chxzyfps.shoppinglist.data.AppDatabase
import com.chxzyfps.shoppinglist.data.ShopListDao
import com.chxzyfps.shoppinglist.data.ShopListRepositoryImpl
import com.chxzyfps.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {
        @Provides
        fun provideShopListDao(application: Application) : ShopListDao {
            return AppDatabase.getInstance(application).shopListdao()
        }
    }


}