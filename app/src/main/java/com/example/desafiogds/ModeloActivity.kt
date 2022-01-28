package com.example.desafiogds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.desafiogds.databinding.ActivityModeloBinding
import com.example.desafiogds.db.DatabaseHandler
import com.example.desafiogds.db.FeedReaderContract

class ModeloActivity : AppCompatActivity() {
    val dbHelper = DatabaseHandler(this)

    private lateinit var binding: ActivityModeloBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Funcionaa")
        setContentView(R.layout.activity_marca)
        binding= ActivityModeloBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnVoltarModelo.setOnClickListener {
            voltarModelo()
        }

        obterMarcas()
    }
    private fun voltarModelo(){
        val voltarTela = Intent (this, HomeActivity::class.java)
        startActivity(voltarTela)
    }

    private fun obterMarcas() {
        val db = dbHelper.readableDatabase
        val select = arrayOf(BaseColumns._ID, FeedReaderContract.FeedEntry.COLUMN_NAME_MARCA)
        val cursor = db.query(
            FeedReaderContract.FeedEntry.TABLE_NAME,
            select,
            null,
            null,
            null,
            null,
            null
        )

        /*val items: Array<Marca> = arrayOf()
        with(cursor) {
            while (moveToNext()) {
                val itemId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                val itemMarca = getString(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_MARCA))
                items.plus(Marca(itemId,itemMarca))
            }
        }*/

        //Percorre o retorno dos itens do banco. Tabela Marcas
        val marcas = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val marca = getString(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_MARCA))
                marcas.add(marca)
            }
        }

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, marcas)
        selectMarca.adapter = arrayAdapter

        cursor.close()

        println(marcas.toString())

        Log.v("teste", marcas.toString());
        Toast.makeText( this, marcas.toString(), Toast.LENGTH_LONG).show()
        //println(cursor);


        /*val spinnerAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cursor)

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        seu_spinner.setAdapter(spinnerAdapter)*/

       /*Toast.makeText( this, cursor, Toast.LENGTH_SHORT).show()*/
    }


}