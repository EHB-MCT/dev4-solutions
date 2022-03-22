class CoinSubscriber(val name: String) {
    var rate = CoinPublisher.getCoinRate(name)

    init {
        CoinPublisher.add(this)
    }

    fun update(r: Double)  {
        rate = r
        println("The rate for $name has been changed: $rate")
    }
}