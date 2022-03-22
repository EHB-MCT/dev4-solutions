package drawers

import java.awt.Point

interface IFigureDrawable {
    fun drawCircle(centre: Point, diameter: Float)
    fun drawRectangle(leftup: Point, height: Int, width: Int)
    fun drawTriangle(one: Point, two: Point, three: Point)
    fun drawSquare(rightup: Point, size: Int)
}