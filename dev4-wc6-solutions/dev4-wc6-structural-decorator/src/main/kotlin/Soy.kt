class Soy(override var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Soy"
    override fun cost(): Double {
        return beverage.cost() + 1.19;
    }
}