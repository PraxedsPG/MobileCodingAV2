package devandroid.vinicius.megamotors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class veiculoAdapter(private val veicList: ArrayList<dbMegaVeiculos>) :
    RecyclerView.Adapter<veiculoAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val veicmarca : TextView = itemView.findViewById(R.id.txtMarca)
        val veicano : TextView = itemView.findViewById(R.id.txtAno)
        val veicmodelo : TextView = itemView.findViewById(R.id.txtModelo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.veiculo_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMarca = veicList[position]
        holder.veicmarca.text = currentMarca.userMark

        val currentAno = veicList[position]
        holder.veicano.text = currentAno.userYear

        val currentModelo = veicList[position]
        holder.veicmodelo.text = currentModelo.userModel
    }

    override fun getItemCount(): Int {
        return veicList.size
    }



}


