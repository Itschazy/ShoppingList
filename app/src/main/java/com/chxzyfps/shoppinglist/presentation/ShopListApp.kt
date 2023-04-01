package com.chxzyfps.shoppinglist.presentation

import android.app.Application
import com.chxzyfps.shoppinglist.di.DaggerApplicationComponent

class ShopListApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}