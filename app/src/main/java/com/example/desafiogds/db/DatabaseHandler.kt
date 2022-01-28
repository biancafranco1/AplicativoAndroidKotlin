package com.example.desafiogds.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.ID
import android.provider.BaseColumns
import com.example.desafiogds.db.FeedReaderContract.FeedEntry.COLUMN_NAME_MARCA
import com.example.desafiogds.db.FeedReaderContract.FeedEntry.TABLE_NAME

object FeedReaderContract {
      object FeedEntry : BaseColumns {
        const val TABLE_NAME = "Marcas"
        const val COLUMN_NAME_MARCA = "marca"
    }
}
private const val CREATE_TABLE = "CREATE TABLE ${FeedReaderContract.FeedEntry.TABLE_NAME}(${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${FeedReaderContract.FeedEntry.COLUMN_NAME_MARCA} TEXT)"

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DB_NAME, null, DB_VERSION){
    companion object{
        const val DB_VERSION = 1
        const val DB_NAME = "Cadware"
    }
    override fun onCreate(db: SQLiteDatabase) { db.execSQL(CREATE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}
























/*class DatabaseHandler(ctx: Context): SQLiteOpenHelper(ctx,DB_NAME, null, DB_VERSION){
    companion object{
        private val DB_VERSION = 1
        private val DB_NAME = "Cadware"
        private val TABLE_NAME = "Marcas"
        private val ID = "id"
        private val MARCA = "Marca"
    }
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $MARCA TEXT"
    override fun onCreate(db: SQLiteDatabase) { db.execSQL(CREATE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}
*/






