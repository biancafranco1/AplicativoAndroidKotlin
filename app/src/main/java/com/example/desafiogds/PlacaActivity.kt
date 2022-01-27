package com.example.desafiogds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
    private fun voltarPlaca(){
        val voltarTela = Intent (this, HomeActivity::class.java)
        startActivity(voltarTela)
    }
}