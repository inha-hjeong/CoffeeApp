package com.aac.coffeeapp.ui.screen.order.mapper

import androidx.compose.runtime.mutableStateOf
import com.aac.coffeeapp.data.CoffeeDrink
import com.aac.coffeeapp.ui.screen.order.model.OrderCoffeeDrink

class OrderCoffeeDrinkMapper {

    fun map(coffeeDrink: CoffeeDrink): OrderCoffeeDrink {
        return OrderCoffeeDrink(
            id = coffeeDrink.id,
            name = coffeeDrink.name,
            imageRes = coffeeDrink.imageUrl,
            description = coffeeDrink.orderDescription,
            price = coffeeDrink.price,
            count = mutableStateOf(0)
        )
    }
}
