abstract class TreeComponent {
    open lateinit var name: String
    open fun addChild(o: TreeComponent) {
        throw UnsupportedOperationException()
    }

    open fun removeChild(i: Int): TreeComponent? {
        throw UnsupportedOperationException()
    }

    open fun removeChild(o: TreeComponent) {
        throw UnsupportedOperationException()
    }

    open fun getChild(i: Int): TreeComponent? {
        throw UnsupportedOperationException()
    }
}