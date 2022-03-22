class RoutePlanner {
    lateinit var route: Route

    init{
        println("How would you like to travel?")
        //Read out the user input and create the proper route
        val input = readLine()


        when(input) {
            "walk" -> route = WalkRoute()
            "bike" -> route = BikeRoute()
            "car" -> route = CarRoute()
        }

        println(route.createRoute())
    }
}
