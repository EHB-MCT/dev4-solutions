fun main(args: Array<String>) {
    println("Let's build a food factory")

    val kitchen = DarkKitchen()
    println(kitchen.menu)
    kitchen.addItemToMenu("BURGER", "Cheeseburger", 6.99)
    kitchen.addItemToMenu("BURGER", "Fish burger", 8.99)
    kitchen.addItemToMenu("PIZZA", "Margherita", 9.99)

    println(kitchen.menu)
    kitchen.addDiscountToAll(10)
    for(item in kitchen.menu) {
        println(item.price.toString())
    }
}

interface Meal {
    val type: String
    val name: String
    var price: Double
}

class Burger(override val name: String, override var price: Double) : Meal {
    override val type = "Burger"
}

class Pizza(override val name: String, override var price: Double) : Meal {
    override val type = "Pizza"
}

class Sushi(override val name: String, override var price: Double) : Meal {
    override val type = "Sushi"
}

class DarkKitchen {
    var menu = mutableListOf<Meal>()

    fun addItemToMenu(type: String, name: String, price: Double) {
        when(type) {
            "BURGER" -> menu.add(Burger(name, price))
            "PIZZA" -> menu.add(Pizza(name, price))
            "SUSHI" -> menu.add(Sushi(name, price))
            else -> null
        }
    }

    fun addDiscountToAll(percentage: Int) {
        for(item in menu) {
            var amount = item.price / 100 * percentage
            item.price -= amount
        }
    }

}

