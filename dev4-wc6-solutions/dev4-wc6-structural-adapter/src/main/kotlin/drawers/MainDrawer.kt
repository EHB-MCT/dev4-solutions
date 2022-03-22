package drawers

import java.awt.Point

class MainDrawer {
    fun drawAllKindsOfFigures(drawer: IFigureDrawable) {
        drawer.drawCircle(Point(1, 2), 15.6f)
        drawer.drawCircle(Point(1, 3), 15.6f)
        drawer.drawCircle(Point(2, 2), 15.6f)
        drawer.drawCircle(Point(5, 2), 15.6f)
        drawer.drawCircle(Point(2, 2), 15.6f)
        drawer.drawCircle(Point(5, 2), 15.6f)
        drawer.drawCircle(Point(2, 2), 15.6f)
        drawer.drawRectangle(Point(1, 2), 10, 50)
        drawer.drawRectangle(Point(1, 3), 10, 50)
        drawer.drawRectangle(Point(1, 5), 10, 50)
        drawer.drawRectangle(Point(1, 6), 10, 50)
        drawer.drawRectangle(Point(2, 2), 10, 50)
        drawer.drawRectangle(Point(56, 2), 10, 50)
        drawer.drawRectangle(Point(3, 2), 10, 50)
        drawer.drawRectangle(Point(3, 2), 25, 50)
        drawer.drawSquare(Point(1, 2), 15)
        drawer.drawSquare(Point(1, 3), 15)
        drawer.drawSquare(Point(1, 4), 15)
        drawer.drawSquare(Point(2, 2), 15)
        drawer.drawSquare(Point(2, 5), 15)
        drawer.drawSquare(Point(2, 2), 15)
        drawer.drawSquare(Point(2, 2), 15)
        drawer.drawTriangle(Point(1, 2), Point(3, 5), Point(5, 5))
    }
}