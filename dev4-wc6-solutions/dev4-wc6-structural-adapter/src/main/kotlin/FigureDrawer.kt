import java.awt.Point

class FigureDrawer {

    fun drawCircle(centre: Point, radius:Float){
        println("Drawing a CIRCLE with centre ${convertPoint(centre)} and radius $radius")
    }
    fun drawRectangle(leftUp : Point, rightDown : Point){
        println("Drawing a RECTANGLE with left up point ${convertPoint(leftUp)} and right down point ${convertPoint(rightDown)}")
    }
    fun drawTriangle(one: Point, two: Point, three: Point){
        println("Drawing a TRIANGLE from ${convertPoint(one)} to ${convertPoint(two)} and ending at ${convertPoint(three)}")
    }
    fun drawSquare(leftUp : Point, size: Int){
        println("Drawing a SQUARE with left up point ${convertPoint(leftUp)} and size $size")
    }

    private fun convertPoint(p: Point): String{
        return "[x=${p.x},y=${p.y}]"
    }
}