package com.example.desafiogds.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(ctx: Context): SQLiteOpenHelper(ctx,DB_NAME, null, DB_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $MARCA TEXT"
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    companion object{
        private val DB_VERSION = 1
        private val DB_NAME = "Cadware"
        private val TABLE_NAME = "Marcas"
        private val ID = "id"
        private val MARCA = "Marca"
    }
}
