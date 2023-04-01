package com.chxzyfps.shoppinglist.di

import android.app.Application
import com.chxzyfps.shoppinglist.presentation.MainActivity
import com.chxzyfps.shoppinglist.presentation.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [DataModule::class, ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: ShopItemFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }

}