package com.example.registroalumnos.basededatos

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Alumnos" )
class ElementosBBDD (
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    var nombre: String = "",
    var apellidos:String="",
    var curso:String =""


)




