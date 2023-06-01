package devandroid.vinicius.megamotors

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import devandroid.vinicius.megamotors.databinding.VeiculoItemBinding

class veiculoAdapter(private val context: Context, private val listaDeVeiculo: MutableList<dbMegaVeiculos>):
    RecyclerView.Adapter<veiculoAdapter.VeiculoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VeiculoViewHolder {
        val itemLista = VeiculoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return VeiculoViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: VeiculoViewHolder, position: Int) {
        holder.txtMarca.text = listaDeVeiculo [position].userMark
        holder.txtModelo.text = listaDeVeiculo [position].userModel
        holder.txtAno.text = listaDeVeiculo [position].userYear
    }

    override fun getItemCount() = listaDeVeiculo.size

    inner class VeiculoViewHolder(binding: VeiculoItemBinding): RecyclerView.ViewHolder(binding.root) {
        val txtMarca = binding.txtMarca
        val txtModelo = binding.txtModelo
        val txtAno = binding.txtAno
    }

}