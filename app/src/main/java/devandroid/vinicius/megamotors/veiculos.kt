package devandroid.vinicius.megamotors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import devandroid.vinicius.megamotors.databinding.ActivityVeiculosBinding


class veiculos : AppCompatActivity() {

    private lateinit var binding: ActivityVeiculosBinding
    private lateinit var adapterVeiculo: veiculoAdapter
    private val listaVeiculos: MutableList<dbMegaVeiculos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVeiculosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewVeiculos = binding.recyclerViewVeiculos
        recyclerViewVeiculos.layoutManager = LinearLayoutManager(this)
        recyclerViewVeiculos.setHasFixedSize(true)
        adapterVeiculo = veiculoAdapter(this,listaVeiculos)
        recyclerViewVeiculos.adapter = adapterVeiculo
    }
}