package devandroid.vinicius.megamotors

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import devandroid.vinicius.megamotors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

            var name = binding.Nome
            var mail = binding.Email
            var password = binding.Senha

        dbRef = FirebaseDatabase.getInstance().getReference("Usuario")

        binding.Button.setOnClickListener {

            val nome = binding.Nome.text.toString()
            val email = binding.Email.text.toString()
            val senha = binding.Senha.text.toString()

          if(nome.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty()) {

              val userId = dbRef.push().key!!

              val dadosUsuario = dbMegaMotors(nome, email, senha)


              dbRef.child(userId).setValue(dadosUsuario).addOnCompleteListener{
                  Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                  name.text.clear()
                  mail.text.clear()
                  password.text.clear()

              }.addOnFailureListener{err ->
                  Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
              }
              val intent = Intent(this, cadastrodeVeiculo::class.java)
              startActivity(intent)
          }
        }
    }
}



