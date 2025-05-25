package mg.espa.tco.get

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val boutonAjouter = findViewById<Button>(R.id.AjouterProduit)
        boutonAjouter.setOnClickListener {
            val bottomSheet = AjouterProduitBottomSheet()
            bottomSheet.show(supportFragmentManager, "AjouterProduit")
        }
    }
}
class ListeProduitsFragment : Fragment() {

    private val produits = mutableListOf<Produit>() // Données simulées

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_liste_produits, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerProduits)
        val emptyMessage = view.findViewById<TextView>(R.id.emptyMessage)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProduitAdapter(produits)

        if (produits.isEmpty()) {
            emptyMessage.visibility = View.VISIBLE
        }

        return view
    }
}
