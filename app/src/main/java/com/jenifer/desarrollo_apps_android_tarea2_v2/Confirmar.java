package com.jenifer.desarrollo_apps_android_tarea2_v2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmar extends AppCompatActivity {
    private TextView nombre, fecha, telefono, email, descripcion;
    private String nombre_recibido, fecha_recibido, telefono_recibido, email_recibido, descripcion_recibido;

    public static final String dato_nombre      ="Nombre";
    public static final String dato_fecha       ="FechaNac";
    public static final String dato_telefono    ="Telefono";
    public static final String dato_email       ="Email";
    public static final String dato_descripcion="Descripcion de contacto";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        nombre=(TextView)findViewById(R.id.tvNombre);
        fecha=(TextView)findViewById(R.id.tvFecha_Nac);
        telefono=(TextView)findViewById(R.id.tvTelefono);
        email=(TextView)findViewById(R.id.tvEmail);
        descripcion=(TextView)findViewById(R.id.tvDescripContacto);

        Intent dato=getIntent();
        nombre_recibido                 =(String)dato.getStringExtra(dato_nombre);
        fecha_recibido                  =(String)dato.getStringExtra(dato_fecha);
        telefono_recibido               =(String)dato.getStringExtra(dato_telefono);
        email_recibido                  =(String)dato.getStringExtra(dato_email);
        descripcion_recibido            =(String)dato.getStringExtra(dato_descripcion);
        nombre.setText(nombre_recibido);
        fecha.setText("Fecha de nacimiento: "+fecha_recibido);
        telefono.setText("Tel: "+telefono_recibido);
        email.setText("Email: "+email_recibido);
        descripcion.setText( "Descripción: \n"+descripcion_recibido);

    }
    //************método Editar***********
    public void Edition(View view){
        Intent editar=new Intent(this,MainActivity.class);
        editar.putExtra(MainActivity.edita_nombre, nombre_recibido);
        editar.putExtra(MainActivity.edita_fecha, fecha_recibido);
        editar.putExtra(MainActivity.edita_telefono, telefono_recibido);
        editar.putExtra(MainActivity.edita_email, email_recibido);
        editar.putExtra(MainActivity.edita_descripcion, descripcion_recibido);
        startActivity(editar);
        finish();
    }
}