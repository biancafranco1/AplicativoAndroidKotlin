package com.example.desafiogds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiogds.databinding.ActivityMarcaBinding
import com.example.desafiogds.databinding.ActivityModeloBinding

class ModeloActivity : AppCompatActivity() {
    private lateinit var binding: ActivityModeloBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marca)
        binding= ActivityModeloBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnVoltarModelo.setOnClickListener {
            voltarModelo()
        }
    }
    private fun voltarModelo(){
        val voltarTela = Intent (this, HomeActivity::class.java)
        startActivity(voltarTela)
    }
}