package com.example.registroalumnos.basededatos

import android.app.Application
import androidx.room.Database
import androidx.room.Room

class RegistroApp: Application() {
    companion object{
        lateinit var database: DBLista
    }

    override fun onCreate() {
        super.onCreate()
        RegistroApp.database = Room.databaseBuilder(this,DBLista::class.java,"DBLista").build()
    }
}