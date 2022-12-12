package com.example.registroalumnos.basededatos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities= arrayOf(ElementosBBDD::class),
    version=1
)
abstract class DBLista: RoomDatabase() {
abstract fun listaDao():listaDAO
}