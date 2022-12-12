package com.example.registroalumnos

import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.basededatos.ElementosBBDD
import com.example.registroalumnos.basededatos.RegistroApp
import com.example.registroalumnos.databinding.ActivityActualizarAlumnoBinding
import com.example.registroalumnos.databinding.ActivityRegistrarAlumnoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivityWithMenus() {

    private lateinit var binding:ActivityRegistrarAlumnoBinding
    lateinit var listaalumnos: MutableList<ElementosBBDD>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistrarAlumnoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaalumnos = ArrayList()
        binding.BRegistrar.setOnClickListener{

            if(binding.ETNombreregistrar.text.toString().isEmpty()  or binding.ETApellidosregistrar.text.toString().isEmpty() or  binding.ETCursoregistrar.text.toString().isEmpty()  ){

                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            }

            else{
                // Insertamos en nuestra bbdd el nombre del alumno
                CoroutineScope(Dispatchers.IO).launch {

                    // Información de los campos de texto
                    var Anombre=binding.ETNombreregistrar.text.toString()
                    var Aapellidos= binding.ETApellidosregistrar.text.toString()
                    var Acurso= binding.ETCursoregistrar.text.toString()
                    var alumnado = ElementosBBDD(nombre = Anombre, apellidos = Aapellidos, curso = Acurso)
                    listaalumnos.add(alumnado)

                    // Llamamos al metodo addElemento() del DAO para realizar la inserción
                    RegistroApp.database.listaDao().addElemento(alumnado)
                    clearFocus()
                }
            }


            }

        }
    fun clearFocus(){
        binding.ETNombreregistrar.setText("")
        binding.ETApellidosregistrar.setText("")
        binding.ETCursoregistrar.setText("")
    }
    }
