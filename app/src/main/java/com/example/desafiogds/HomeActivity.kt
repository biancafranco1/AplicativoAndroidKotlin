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
    //funcionalidade dos botões
        binding.btnCadMarca.setOnClickListener {
            cadMarca()
        }
        binding.btnCadModelo.setOnClickListener {
            cadModelo()
        }
        binding.btnCadPlaca.setOnClickListener {
            cadPlaca()
        }
    }
    private fun cadMarca () {
        val segundaTela = Intent(this, MarcaActivity::class.java)
        startActivity(segundaTela)
    }
    private fun cadModelo (){
        val terceiraTela = Intent(this, ModeloActivity::class.java)
        startActivity(terceiraTela)
    }
    private fun cadPlaca (){
        val quartaTela=Intent(this, PlacaActivity::class.java)
        startActivity(quartaTela)
    }
}
