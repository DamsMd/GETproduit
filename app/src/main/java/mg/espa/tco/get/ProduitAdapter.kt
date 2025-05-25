package mg.espa.tco.get

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProduitAdapter(private val produits: List<Produit>) :
    RecyclerView.Adapter<ProduitAdapter.ProduitViewHolder>() {

    class ProduitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nom = itemView.findViewById<TextView>(R.id.nomProduit)
        val prix = itemView.findViewById<TextView>(R.id.prixProduit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProduitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produit, parent, false)
        return ProduitViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProduitViewHolder, position: Int) {
        val produit = produits[position]
        holder.nom.text = produit.nom
        holder.prix.text = "${produit.prix} €"
    }

    override fun getItemCount() = produits.size
}
