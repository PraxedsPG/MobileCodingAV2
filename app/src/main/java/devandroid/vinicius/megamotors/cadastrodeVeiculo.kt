package devandroid.vinicius.megamotors

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import devandroid.vinicius.megamotors.databinding.ActivityCadastrodeVeiculoBinding

class cadastrodeVeiculo : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrodeVeiculoBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrodeVeiculoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        var marca = binding.formMarca
        var ano = binding.formAno
        var modelo = binding.formModelo

        dbRef = FirebaseDatabase.getInstance().getReference("Carro")


        binding.btnCadastrarVeiculos.setOnClickListener {


            val mark = binding.formMarca.text.toString()
            val year = binding.formAno.text.toString()
            val model = binding.formModelo.text.toString()

            if(mark.isNotEmpty() && year.isNotEmpty() && model.isNotEmpty()) {

                val carroId = dbRef.push().key!!

                val dadosCarro = dbMegaVeiculos(mark,year,model)

                dbRef.child(carroId).setValue(dadosCarro).addOnCompleteListener{
                    Toast.makeText(this, "Carro Cadastrado", Toast.LENGTH_SHORT).show()

                    marca.text.clear()
                    ano.text.clear()
                    modelo.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.btnVizualizarVeiculos.setOnClickListener{
            irParaVeiculos()
        }
    }

    private fun irParaVeiculos() {
        val intent = Intent(this, veiculos::class.java)
        startActivity(intent)
    }
}