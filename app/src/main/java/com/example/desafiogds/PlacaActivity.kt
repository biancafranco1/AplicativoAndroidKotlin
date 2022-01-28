package com.example.desafiogds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.desafiogds.databinding.ActivityModeloBinding
import com.example.desafiogds.databinding.ActivityPlacaBinding

class PlacaActivity : AppCompatActivity() {
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


    }
    private fun voltarPlaca(){
        val voltarTela = Intent (this, HomeActivity::class.java)
        startActivity(voltarTela)
    }
}