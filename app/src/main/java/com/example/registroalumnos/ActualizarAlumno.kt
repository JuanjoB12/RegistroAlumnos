package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.basededatos.ElementosBBDD
import com.example.registroalumnos.basededatos.RegistroApp
import com.example.registroalumnos.databinding.ActivityActualizarAlumnoBinding
import com.example.registroalumnos.databinding.ActivityRegistrarAlumnoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActualizarAlumno : ActivityWithMenus() {

    private lateinit var bindingA: ActivityActualizarAlumnoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingA= ActivityActualizarAlumnoBinding.inflate(layoutInflater)
        setContentView(bindingA.root)
        bindingA.BActualizar.setOnClickListener {
            if(bindingA.ETNombreActualizar.text.toString().isEmpty()  or bindingA.ETCursoactualizar.text.toString().isEmpty()   ){

                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }
            else{
                CoroutineScope(Dispatchers.IO).launch {
                    var Anombre=bindingA.ETNombreActualizar.text.toString()
                    var Acurso=bindingA.ETCursoactualizar.text.toString()

                    var actualizaralum: ElementosBBDD
                    actualizaralum = RegistroApp.database.listaDao().obteneralumnonombre(Anombre)
                    //bindingA.ETNombreActualizar=
                    actualizaralum.curso=Acurso

                    RegistroApp.database.listaDao().update(actualizaralum)

                    clearFocus()

                }
            }
    }


}

    fun clearFocus(){
        bindingA.ETNombreActualizar.setText("")
        bindingA.ETCursoactualizar.setText("")

    }

}