package com.aac.coffeeapp.di

import com.aac.coffeeapp.data.CoffeeDrinkRepository
import com.aac.coffeeapp.data.CoffeeDrinkDataSource
import com.aac.coffeeapp.data.DummyCoffeeDrinksDataSource
import com.aac.coffeeapp.data.RuntimeCoffeeDrinkRepository
import com.aac.coffeeapp.data.order.OrderCoffeeDrinksRepository
import com.aac.coffeeapp.data.order.RuntimeOrderCoffeeDrinksRepository
import com.aac.coffeeapp.ui.screen.coffeedetails.CoffeeDrinkDetailsViewModel
import com.aac.coffeeapp.ui.screen.coffeedetails.mapper.CoffeeDrinkDetailMapper
import com.aac.coffeeapp.ui.screen.coffeedrinks.CoffeeDrinksViewModel
import com.aac.coffeeapp.ui.screen.coffeedrinks.mapper.CoffeeDrinkItemMapper
import com.aac.coffeeapp.ui.screen.order.OrderCoffeeDrinkViewModel
import com.aac.coffeeapp.ui.screen.order.mapper.OrderCoffeeDrinkMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory<CoffeeDrinkDataSource> { DummyCoffeeDrinksDataSource() }
    single<CoffeeDrinkRepository> { RuntimeCoffeeDrinkRepository }
    single<OrderCoffeeDrinksRepository> {
        RuntimeOrderCoffeeDrinksRepository(
            coffeeDrinkDataSource = get(),
            orderCoffeeDrinkMapper = get()
        )
    }
}

val mapperModule = module {
    factory { CoffeeDrinkItemMapper() }
    factory { CoffeeDrinkDetailMapper() }
    factory { OrderCoffeeDrinkMapper() }

    factory { com.aac.coffeeapp.data.order.OrderCoffeeDrinkMapper() }
}

val viewModelModule = module {
    viewModel {
        OrderCoffeeDrinkViewModel(
            repository = get()
        )
    }
    viewModel {
        CoffeeDrinksViewModel(
            repository = get(),
            mapper = get()
        )
    }
    viewModel {
        CoffeeDrinkDetailsViewModel(
            repository = get(),
            mapper = get()
        )
    }
}
