package com.example.desafiogds

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.desafiogds.databinding.ActivityModeloBinding
import com.example.desafiogds.databinding.ActivityPlacaBinding
import com.example.desafiogds.db.DatabaseHandler
import com.example.desafiogds.db.DatabaseHandlerPlaca
import com.example.desafiogds.db.FeedReaderContractModelo
import com.example.desafiogds.db.FeedReaderContractPlaca

class PlacaActivity : AppCompatActivity() {
    private val dbHelperPlaca = DatabaseHandler (this)
    private lateinit var binding: ActivityPlacaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marca)
        binding= ActivityPlacaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnVoltarPlaca.setOnClickListener {
            voltarPlaca()
        }
        //spinner- lista de opções
        val listaSpnMarca2 = arrayListOf("Fiat", "Ford", "GM")
        val spinnerAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaSpnMarca2)
        binding.selectMarca3.adapter = spinnerAdapter2

        val listaSpnMarca3 = arrayListOf("Uno", "Siena", "Eco Sport", "Celta", "Spin")
        val spinnerAdapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaSpnMarca3)
        binding.selectModelo.adapter = spinnerAdapter3


        binding.btnGravarPlaca.setOnClickListener {
            val placa = binding.inoutPlaca.text.toString().trim()
            //val placaObj = Placa (1, placa)
            val  dbPlaca = dbHelperPlaca.writableDatabase
            val values = ContentValues().apply {
                put(FeedReaderContractPlaca.FeedEntryPlaca.COLUMN_NAME_PLACA, placa)
            }
            val newRowIdPlaca = dbPlaca?.insert(FeedReaderContractPlaca.FeedEntryPlaca.TABLE_NAME_PLACA, null, values)
            Toast.makeText(this, "A placa " + placa + " foi cadastrada com sucesso.", Toast.LENGTH_SHORT).show()
             }

    }

    private fun voltarPlaca(){
        val voltarTela = Intent (this, HomeActivity::class.java)
        startActivity(voltarTela)
    }
}