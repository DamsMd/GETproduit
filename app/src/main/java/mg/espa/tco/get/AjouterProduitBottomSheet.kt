package mg.espa.tco.get

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AjouterProduitBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext())
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_ajouter_produit, null)

        val nomProduit = view.findViewById<EditText>(R.id.editNom)
        val prixProduit = view.findViewById<EditText>(R.id.editPrix)
        val btnValider = view.findViewById<Button>(R.id.btnValider)



        btnValider.setOnClickListener {
            val nom = nomProduit.text.toString()
            val prix = prixProduit.text.toString()
            // TODO : Enregistrer le produit
            dismiss()
        }

        dialog.setContentView(view)
        return dialog
    }
}
