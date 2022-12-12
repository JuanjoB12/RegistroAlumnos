package com.example.registroalumnos.basededatos

import androidx.room.*

@Dao
interface listaDAO {

    @Query("SELECT * FROM Alumnos")
    fun getAllElements():MutableList<ElementosBBDD>
    // Registrar un nuevo alumno
    @Insert
    fun addElemento(taskEntity: ElementosBBDD):Long

    // Volvemos a actualizar la consulta
    @Query("SELECT * FROM Alumnos WHERE nombre like:nombre")
    fun obteneralumnonombre(nombre: String):ElementosBBDD

    @Update
    fun update(taskEntity: ElementosBBDD):Int

    @Delete
    fun deleteElemento(taskEntity: ElementosBBDD):Int



}