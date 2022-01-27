package com.example.desafiogds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.desafiogds.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCadMarca.setOnClickListener {
            cadMarca()
        }
    }
    private fun cadMarca () {
        val segundaTela = Intent(this, MarcaActivity::class.java)
        startActivity(segundaTela)


        binding.btnCadModelo.setOnClickListener {
            cadModelo()
        }
    }
    private fun cadModelo (){
        val terceiraTela = Intent(this, ModeloActivity::class.java)
        startActivity(terceiraTela)

        binding.btnCadPlaca.setOnClickListener {
            cadPlaca()
        }
    }
    private fun cadPlaca (){
        val quartaTela=Intent(this, PlacaActivity::class.java)
        startActivity(quartaTela)
    }



}
