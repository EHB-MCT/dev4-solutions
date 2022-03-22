class AlmondMilk(override var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Almond Milk"
    override fun cost(): Double {
        return beverage.cost() + 1.49;
    }
}