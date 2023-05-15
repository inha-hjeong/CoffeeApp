package com.aac.coffeeapp.ui.screen.coffeedetails.mapper

import com.aac.coffeeapp.data.CoffeeDrink
import com.aac.coffeeapp.ui.screen.coffeedetails.model.CoffeeDrinkDetail

class CoffeeDrinkDetailMapper {

    fun map(coffeeDrink: CoffeeDrink?): CoffeeDrinkDetail? {
        if (coffeeDrink == null) {
            return null
        }

        return CoffeeDrinkDetail(
            id = coffeeDrink.id,
            name = coffeeDrink.name,
            imageUrl = coffeeDrink.imageUrl,
            ingredients = coffeeDrink.ingredients,
            description = coffeeDrink.description,
            isFavourite = coffeeDrink.isFavourite
        )
    }
}
