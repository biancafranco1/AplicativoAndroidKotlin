package com.example.desafiogds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiogds.databinding.ActivityHomeBinding
import com.example.desafiogds.databinding.ActivityMarcaBinding

class MarcaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMarcaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marca)
        binding= ActivityMarcaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnVoltarMarca.setOnClickListener {
            voltarMarca()
        }
    }
    private fun voltarMarca(){
        val voltarTela = Intent (this, HomeActivity::class.java)
        startActivity(voltarTela)
    }
}
//alguma coisa