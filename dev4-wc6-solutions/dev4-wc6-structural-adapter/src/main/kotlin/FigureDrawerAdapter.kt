
import drawers.IFigureDrawable
import java.awt.Point


class FigureDrawerAdapter(private val figureDrawer: FigureDrawer) : IFigureDrawable {

    override fun drawCircle(centre: Point, diameter: Float) {
        figureDrawer.drawCircle(centre, diameter / 2)
    }

    override fun drawRectangle(leftup: Point, height: Int, width: Int) {
        figureDrawer.drawRectangle(leftup, Point(leftup.x + width, leftup.y + height))
    }

    override fun drawTriangle(one: Point, two: Point, three: Point) {
        figureDrawer.drawTriangle(one, two, three)
    }

    override fun drawSquare(rightup: Point, size: Int) {
        figureDrawer.drawSquare(Point(rightup.x - size, rightup.y), size)
    }
}