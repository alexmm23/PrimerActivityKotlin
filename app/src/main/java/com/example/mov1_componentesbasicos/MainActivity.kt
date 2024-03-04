package com.example.mov1_componentesbasicos

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var objCliente: Cliente
    private lateinit var objProducto: Producto

    private lateinit var titulo: TextView
    private lateinit var nom: EditText
    private lateinit var correo: EditText
    private lateinit var tel: EditText
    private lateinit var con: EditText
    private lateinit var nip: EditText
    private lateinit var cp: EditText
    private lateinit var comm: EditText
    private lateinit var fecha: EditText
    private lateinit var hora: EditText
    private lateinit var codigo: EditText
    private lateinit var costo : EditText
    private lateinit var desc : AutoCompleteTextView
    private lateinit var cancel : Button

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        objCliente = Cliente()
        objProducto = Producto("00-00-00","00:00",123,0.1,"Nuevo producto")
        titulo = findViewById(R.id.txtTitulo)
        nom = findViewById(R.id.edtNom)
        //var correo = findViewById<EditText>(R.id.edtCorreo)

        correo = findViewById(R.id.edtCorreo)
        tel = findViewById(R.id.edtTelefono)
        con = findViewById(R.id.edtContrasena)
        nip = findViewById(R.id.edtNip)
        cp = findViewById(R.id.edtCp)
        comm = findViewById(R.id.edtComentarios)
        fecha = findViewById(R.id.edtFecha)
        hora = findViewById(R.id.edtHora)
        codigo = findViewById(R.id.edtCodigo)
        costo = findViewById(R.id.edtCosto)
        cancel = findViewById(R.id.btnCancelar)
        desc = findViewById(R.id.edtDesc)

        val productos : Array<String> = resources.getStringArray(R.array.lista_productos)
        val adapter : ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,productos)
        desc.setAdapter(adapter)
        titulo.apply {
            text = "Formulario de venta"
            setTextColor(Color.BLUE)
        }
        titulo.setOnClickListener{
            titulo.setTextColor(Color.BLUE)
            Toast.makeText(this, "Cambio de color", Toast.LENGTH_LONG).show()
        }

        cancel.setOnClickListener {
            Toast.makeText(this, "Cancelar informacion", Toast.LENGTH_LONG).show()
        }


    }

    fun registrar(view: View?){
        //Toast.makeText(this, "Entro a registrar", Toast.LENGTH_LONG).show()
        if(nom.text.isNotEmpty() && con.text.isNotEmpty() && nip.text.isNotEmpty()){
            objCliente.nombre = nom.text.toString()
            objCliente.contrasena = con.text.toString()
            objCliente.nip = nip.text.toString().toInt()

            objCliente.correo = correo.text.toString()
            objCliente.telefono = tel.text.toString()

            objCliente.cp = Integer.parseInt(cp.text.toString())
            objCliente.comentarios = comm.text.toString()

            objProducto.fecha = fecha.text.toString()
            objProducto.hora = hora.text.toString()
            objProducto.codigo = Integer.parseInt(comm.text.toString())
            objProducto.costo = costo.text.toString().toDouble()

            Toast.makeText(this, "Nombre ${objCliente.nombre} registrado \n El producto: ${objProducto.descripcion} \n Código: ${objProducto.codigo}", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this, "No puede haber campos vacios", Toast.LENGTH_SHORT)
        }
        //Toast.makeText(this, "Nombre ${objCliente.nombre} registrado \n El producto: ${objProducto.descripcion} \n Código: ${objProducto.codigo}", Toast.LENGTH_LONG).show()
    }
    fun mostrarEnCajasTexto(){
        nom.setText(objCliente.nombre)
        con.setText(objCliente.contrasena)
        nip.setText(objCliente.nip)
        correo.setText(objCliente.correo)
        tel.setText(objCliente.telefono)
        cp.setText(objCliente.cp)
        comm.setText(objCliente.comentarios)
        fecha.setText(objProducto.fecha)
        hora.setText(objProducto.hora)
        codigo.setText(objProducto.codigo)
        costo.setText(objProducto.costo.toString())
    }

}