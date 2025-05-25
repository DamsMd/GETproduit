package mg.espa.tco.get

class Produit {
    val prix: String
        get() {
            TODO()
        }
    val nom: CharSequence?
        get() {
            TODO()
        }

    data class Produit(val nom: String, val prix: Double)

}