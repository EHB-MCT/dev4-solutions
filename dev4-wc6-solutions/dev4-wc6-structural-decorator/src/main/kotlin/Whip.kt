class Whip (override var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Whip"
    override fun cost(): Double {
        return beverage.cost() + 0.4;
    }

}