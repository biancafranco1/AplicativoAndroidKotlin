package com.example.desafiogds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
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

    //Consulta de opções do spinner
    private fun obterMarcas() {

        val db = dbHelper.readableDatabase
        //Colunas a ser pesquisadas
        val select = arrayOf(BaseColumns._ID, FeedReaderContract.FeedEntry.COLUMN_NAME_MARCA)
        //Realização da consulta
        val cursor = db.query(
            FeedReaderContract.FeedEntry.TABLE_NAME,
            select,
            null,
            null,
            null,
            null,
            null
        )
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

        //Configura as opções para o spinner
        //Não tinha dado certo :( Tem que ver novos tutoriais no youtube


        cursor.close()

        //Remover depois de estar funcionando o spinner
        Toast.makeText( this, marcas.toString(), Toast.LENGTH_LONG).show()
    }


}