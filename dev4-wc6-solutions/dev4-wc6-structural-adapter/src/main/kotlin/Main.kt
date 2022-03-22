
import drawers.MainDrawer


fun main(args: Array<String>) {
    println("Welcome to the adapter exercise. Try to run the main drawer code with your own adapter ")

    val dr = MainDrawer()
    dr.drawAllKindsOfFigures(FigureDrawerAdapter(FigureDrawer()))

}