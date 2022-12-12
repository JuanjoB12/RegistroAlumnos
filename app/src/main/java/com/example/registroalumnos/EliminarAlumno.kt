package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.basededatos.ElementosBBDD
import com.example.registroalumnos.basededatos.RegistroApp
import com.example.registroalumnos.databinding.ActivityActualizarAlumnoBinding
import com.example.registroalumnos.databinding.ActivityEliminarAlumnoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EliminarAlumno : ActivityWithMenus() {

    private lateinit var bindingE: ActivityEliminarAlumnoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingE= ActivityEliminarAlumnoBinding.inflate(layoutInflater)
        setContentView(bindingE.root)
        bindingE.BEliminar.setOnClickListener(){

            if(bindingE.ETEliminar.text.toString().isEmpty()    ){

                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }
            else{
                CoroutineScope(Dispatchers.IO).launch {
                    var Anombre=bindingE.ETEliminar.text.toString()

                    var eliminaralum: ElementosBBDD
                    eliminaralum = RegistroApp.database.listaDao().obteneralumnonombre(Anombre)
                    //bindingA.ETNombreActualizar=
                    //bindingA.ETNombreActualizar=
                    eliminaralum.nombre=Anombre

                    RegistroApp.database.listaDao().deleteElemento(eliminaralum)


                    clearFocus()


                }
            }

        }

    }
    fun clearFocus(){
        bindingE.ETEliminar.setText("")

    }
}