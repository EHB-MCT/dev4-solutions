import kotlin.concurrent.timer

object CoinPublisher {
    var coins = DbController.getCoins();
    var subscribers = mutableListOf<CoinSubscriber>()

    init {
        timer("update", false, 0L, 1000) {
            update();
        }
    }
    fun add(sub: CoinSubscriber) {
        subscribers.add(sub)
    }

    fun getCoinRate(name: String): Double {
        return coins.getValue(name)
    }

    fun update() {
        println("Updating coins...")
        var newCoins = DbController.getCoins()

        newCoins.forEach { (key, value) ->
            if(key in coins && value != coins[key]) {
                //update coins
                coins[key] = value
                //notify subscribers
                val filteredSubscribers = subscribers.filter { it.name == key }
                for (subscriber in filteredSubscribers) {
                  subscriber.update(value)
                }
            }
        }
    }
}

