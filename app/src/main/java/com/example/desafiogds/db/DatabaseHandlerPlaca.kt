package com.example.desafiogds.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.desafiogds.db.DatabaseHandler.Companion.DB_NAME
import com.example.desafiogds.db.DatabaseHandler.Companion.DB_VERSION
import java.text.Collator.PRIMARY


object FeedReaderContractPlaca{
    object FeedEntryPlaca : BaseColumns{
        const val TABLE_NAME_PLACA = "Placas"
        const val COLUMN_NAME_IDMARCA = "idmarca"
        const val COLUMN_NAME_IDMODELO = "idmodelo"
        const val COLUMN_NAME_PLACA = "placa"

    }
}
    private const val CREATE_TABLE_PLACA = "CREATE TABLE ${FeedReaderContractPlaca.FeedEntryPlaca.TABLE_NAME_PLACA}" +
            "(${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "${FeedReaderContractPlaca.FeedEntryPlaca.COLUMN_NAME_PLACA} TEXT)"
    abstract class DatabaseHandlerPlaca (context: Context): SQLiteOpenHelper (context,DB_NAME,null, DB_VERSION){
    companion object{
        const val DB_VERSION = 1
        const val DB_NAME = "Cadware"
    }
        override fun onCreate(db: SQLiteDatabase) {db.execSQL(CREATE_TABLE_PLACA)}
    }
