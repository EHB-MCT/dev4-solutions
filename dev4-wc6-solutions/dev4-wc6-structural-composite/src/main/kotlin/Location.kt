class Location(override var name: String) : TreeComponent() {

    var children: MutableList<TreeComponent> = mutableListOf()


    override fun addChild(o: TreeComponent) {
        children.add(o)
    }

    override fun removeChild(i: Int): TreeComponent {
        return children.removeAt(i) as TreeComponent
    }

    override fun removeChild(o: TreeComponent) {
        children.remove(o)
    }

    override fun getChild(i: Int): TreeComponent {
        return children[i]
    }

    fun showChildren():String{
        var list = "";
        children.forEach{
            list += "${it.name} "
        }
        return list;
    }
}