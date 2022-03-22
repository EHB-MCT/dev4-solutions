class Caramel  (override var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Caramel"
    override fun cost(): Double {
        return beverage.cost() + 0.5;
    }

}