package com.aac.coffeeapp.ui.screen.order.model

import com.aac.coffeeapp.data.order.OrderCoffeeDrink
import java.math.BigDecimal

data class OrderCoffeeDrinkState(
    val coffeeDrinks: List<OrderCoffeeDrink>,
    val totalPrice: BigDecimal
)
