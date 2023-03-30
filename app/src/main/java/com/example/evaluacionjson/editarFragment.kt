package com.example.evaluacionjson

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.evaluacionjson.databinding.FragmentEditarBinding


class editarFragment : Fragment() {
    private var _binding: FragmentEditarBinding? = null
    private val binding get() = _binding!!
    var idSearch: EditText?=null
    val Link = "http://192.168.1.7/Metodos/editCoord.php"




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editarFragment()
        eliminarFragment()

    }

    private fun eliminarFragment() {
        idSearch= binding.txId
        binding.btnEliminar.setOnClickListener {
            val uri="http://192.168.1.7/Metodos/deleteCoord.php"
            val queue= Volley.newRequestQueue(getActivity())
            var resultadoPost = object : StringRequest(Request.Method.POST, uri,
                Response.Listener { response ->
                    Toast.makeText(getActivity(),"El usuario se ha borrado de manera exitosa",
                        Toast.LENGTH_LONG).show()
                }, Response.ErrorListener { error ->
                    Toast.makeText(getActivity(),"Error $error", Toast.LENGTH_LONG).show()
                }){
                override fun getParams(): MutableMap<String, String>? {
                    val parametros = HashMap<String,String>()
                    parametros.put("idC",idSearch?.text.toString())
                    return parametros
                }
            }
            queue.add(resultadoPost)

        }

    }
    private fun editarFragment() {

        binding.btnEditar.setOnClickListener {
            Toast.makeText(context, "AyudameDios", Toast.LENGTH_SHORT).show()
            val reqQueue: RequestQueue = Volley.newRequestQueue(getActivity())
            val resultadoPost = object : StringRequest(Request.Method.POST, Link,
                Response.Listener { res ->
                    Toast.makeText(
                        context,
                        "Editado correctamente",
                        Toast.LENGTH_LONG
                    ).show()
                },
                Response.ErrorListener { err ->
                    Toast.makeText(context, "Error al editar el usuario", Toast.LENGTH_LONG).show()
                    Log.d("MyApp","error",err)
                }
            ) {
                override fun getParams(): MutableMap<String, String>? {
                    val parametros = HashMap<String, String>()
                    parametros.put("idC", binding.txId.text.toString())
                    parametros.put("nombres", binding.txtNombres.text.toString())
                    parametros.put("apellidos", binding.txtApellidos.text.toString())
                    parametros.put("fechaNac", binding.txtFechaNac.text.toString())
                    parametros.put("titulo", binding.txtTitulo.text.toString())
                    parametros.put("email", binding.txtEmail.text.toString())
                    parametros.put("facultad", binding.txtFacultad.text.toString())
                    Log.d("MyApp", "Parametros:$parametros")
                    return parametros
                }
            }
            reqQueue.add(resultadoPost)
        }
    }







    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
