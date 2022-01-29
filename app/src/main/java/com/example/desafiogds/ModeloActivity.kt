package com.example.desafiogds

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.*
import androidx.core.content.contentValuesOf
import com.example.desafiogds.databinding.ActivityModeloBinding
import com.example.desafiogds.db.DatabaseHandler
import com.example.desafiogds.db.DatabaseHandlerModelo
import com.example.desafiogds.db.FeedReaderContractMarca
import com.example.desafiogds.db.FeedReaderContractModelo

    class ModeloActivity : AppCompatActivity() {
    val dbHelperModelo = DatabaseHandler (this)

    //Configura binding
    private lateinit var binding: ActivityModeloBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modelo)
        binding = ActivityModeloBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //spinner- lista de opções
        val listaSpnMarca = arrayListOf("Fiat", "Ford", "GM")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaSpnMarca)
        binding.selectMarca.adapter = spinnerAdapter

        //Funcionalidade pro botão
        binding.btnVoltarModelo.setOnClickListener {
            voltarModelo()
        }

        binding.btnGravarModelo.setOnClickListener {
            val modelo = binding.inoutModelo.text.toString().trim()
           // val modeloObj = Modelo (1, modelo)
            val dbModelo = dbHelperModelo.writableDatabase

            val valuesModelo = ContentValues().apply {
                put(FeedReaderContractModelo.FeedEntryModelo.COLUMN_NAME_MODELO, modelo)
            }
            val newRowIdModelo = dbModelo?.insert(FeedReaderContractModelo.FeedEntryModelo.TABLE_NAME_MODELO,null,valuesModelo)
            Toast.makeText(
                this,
                "O modelo " + modelo + " foi cadastrado com id" + newRowIdModelo,
                Toast.LENGTH_SHORT).show()
        }

    }

        private fun voltarModelo() {
        val voltarTela = Intent(this, HomeActivity::class.java)
        startActivity(voltarTela)
        }

    }




















/* Tentativas de spinner que podem dar certo futuramente
        //Percorre o retorno dos itens do banco. Tabela Marcas
        val marcas = mutableListOf<String>()

        //Busca a marca no resultado da consulta
        with(cursor) {
            while (moveToNext()) {
                val marca = getString(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_MARCA))

                //Lista de marcas que podem ser selecionadas no spinner
                marcas.add(marca)
            }
        }
            //Colunas a serem pesquisadas
            val select = arrayOf(BaseColumns._ID, FeedReaderContractModelo.COLUMN_NAME_MODELO)
            //Realização da consulta
            val cursor = dbModelo.query(
                FeedReaderContractModelo.TABLE_NAME,
                select,
                null,
                null,
                null,
                null,
                null
            )
        cursor.close()}
 */