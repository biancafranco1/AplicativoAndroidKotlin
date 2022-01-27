package com.example.desafiogds

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
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
        binding.inoutMarca.text.toString().trim()

    }
    private fun voltarMarca(){
        val voltarTela = Intent (this, HomeActivity::class.java)
        startActivity(voltarTela)
    }
}

