fun main(args: Array<String>) {
    println("Let's create our file/folder structure for our pictures")

    val root = Location("root")

    val belgie = Location("België")
    root.addChild(belgie)

    val brussel = Location("Brussel")
    belgie.addChild(brussel)
    val antwerpen = Location("Antwerpen")
    belgie.addChild(antwerpen)

    val anderlecht = Location("DT, Anderlecht")
    brussel.addChild(anderlecht)
    anderlecht.addChild(Picture("img10.jpg"))
    anderlecht.addChild(Picture("img11.jpg"))

    val zebra = Location("Zebra, Sint-Goriks")
    brussel.addChild(zebra)
    zebra.addChild(Picture("img12.jpg"))


    antwerpen.addChild(Picture("img9.jpg"))
    antwerpen.addChild(Picture("img8.jpg"))

    val frankrijk = Location("Frankrijk")
    root.addChild(frankrijk)
    val paris = Location("Parijs")
    frankrijk.addChild(paris)
    paris.addChild(Picture("img7.jpg"))
    paris.addChild(Picture("img2.jpg"))

    val spanje = Location("Spanje")
    root.addChild(spanje)
    spanje.addChild(Picture("img2.jpg"))
    spanje.addChild(Picture("img1.jpg"))

    println(root.showChildren())




}