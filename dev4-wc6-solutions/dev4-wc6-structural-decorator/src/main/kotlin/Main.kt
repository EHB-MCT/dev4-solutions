fun main(args: Array<String>) {
    println("Welcome to Starbuzz Coffee!")
    println("Your order is coming up!")

    //Creating the VEGAN DARK
    var veganDark: Beverage = DarkRoast();
    veganDark = AlmondMilk(veganDark)
    println("${veganDark.description} € ${veganDark.cost()}")

    //Creating the CARAMEL LATTE MACHIATO(clm)
    var clm: Beverage = Espresso()
    clm = Milk(clm)
    clm = Milk(clm)
    clm = Caramel(clm)
    println("${clm.description} € ${clm.cost()}")

    //Creating THE HOME SPECIAL
    var homeSpecial: Beverage = HouseBlend()
    homeSpecial = Soy(homeSpecial)
    homeSpecial = Whip(homeSpecial)
    homeSpecial = Caramel(homeSpecial)
    println("${homeSpecial.description} € ${homeSpecial.cost()}")

}