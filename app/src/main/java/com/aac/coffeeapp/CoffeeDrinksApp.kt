package com.aac.coffeeapp

import android.app.Application
import com.aac.coffeeapp.di.dataModule
import com.aac.coffeeapp.di.mapperModule
import com.aac.coffeeapp.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@ExperimentalCoroutinesApi
class CoffeeDrinksApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CoffeeDrinksApp)
            modules(
                listOf(
                    dataModule,
                    mapperModule,
                    viewModelModule
                )
            )
        }
    }
}
