package devandroid.vinicius.megamotors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class veiculos : AppCompatActivity() {

    private lateinit var carRecyclerView:RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var veicList: ArrayList<dbMegaVeiculos>
    private lateinit var dbRef:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veiculos)

        carRecyclerView = findViewById(R.id.listVeiculos)
        carRecyclerView.layoutManager = LinearLayoutManager(this)
        carRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        veicList = arrayListOf<dbMegaVeiculos>()

        getVeiculosData()
    }

    private fun getVeiculosData() {
        carRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

    dbRef = FirebaseDatabase.getInstance().getReference("Carro")

    dbRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            veicList.clear()
            if(snapshot.exists()) {
                for(empSnap in snapshot.children) {
                    val veicData =empSnap.getValue(dbMegaVeiculos::class.java)
                    veicList.add(veicData!!)
                }
                val vAdapter = veiculoAdapter(veicList)
                carRecyclerView.adapter = vAdapter

                carRecyclerView.visibility = View.VISIBLE
                tvLoadingData.visibility = View.GONE
            }
        }
        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    })
    }
}