package com.example.desafiogds.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object FeedReaderContractModelo {
        object FeedEntryModelo : BaseColumns {
            const val TABLE_NAME_MODELO = "Modelos"
            const val COLUMN_NAME_IDMARCA = "idmarca"
            const val COLUMN_NAME_MODELO = "modelo"
        }
    }
            private const val CREATE_TABLE_MODELO =
                "CREATE TABLE MODELO ${FeedReaderContractModelo.FeedEntryModelo.TABLE_NAME_MODELO}" + "(${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, " + "${FeedReaderContractModelo.FeedEntryModelo.COLUMN_NAME_IDMARCA} INTEGER, " +
            "${FeedReaderContractModelo.FeedEntryModelo.COLUMN_NAME_MODELO} TEXT, FOREIGN KEY (idMarca) REFERENCES marca(id))"

            abstract class DatabaseHandlerModelo (context: Context) :
                SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
                companion object {
                    const val DB_VERSION = 1
                    const val DB_NAME = "Cadware"
                }
                override fun onCreate(db: SQLiteDatabase) {db.execSQL(CREATE_TABLE_MODELO)}
                }

                fun onUpgrade(
                    DatabaseHandlerModelo: SQLiteDatabase?,
                    oldVersion: Int,
                    newVersion: Int
                ) {
                    TODO("Not yet implemented")
                }
