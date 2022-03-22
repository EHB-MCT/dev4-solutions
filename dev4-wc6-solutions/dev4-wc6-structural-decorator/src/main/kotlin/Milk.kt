class Milk(override var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Milk"
    override fun cost(): Double {
        return beverage.cost() + 0.85;
    }
}
