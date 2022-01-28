package com.example.desafiogds

import android.app.PendingIntent
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import android.widget.Toast
import com.example.desafiogds.databinding.ActivityHomeBinding
import com.example.desafiogds.databinding.ActivityMarcaBinding
import com.example.desafiogds.db.DatabaseHandler
import com.example.desafiogds.db.FeedReaderContract

class MarcaActivity : AppCompatActivity() {
    val dbHelper = DatabaseHandler(this)
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
        binding.btnGravarMarca.setOnClickListener {
            val marca = binding.inoutMarca.text.toString().trim()
            val marcaObj = Marca (1, marca)
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(FeedReaderContract.FeedEntry.COLUMN_NAME_MARCA, marca)
            }
            val newRowId = db?.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)
            Toast.makeText( this,"A marca " + marca + "foi cadastrada com id " + newRowId, Toast.LENGTH_SHORT).show()
        }

        }
    private fun voltarMarca(){
        val voltarTela = Intent (this, HomeActivity::class.java)
        startActivity(voltarTela)
    }
}

