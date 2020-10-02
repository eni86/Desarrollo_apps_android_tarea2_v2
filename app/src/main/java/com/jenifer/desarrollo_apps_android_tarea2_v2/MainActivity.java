package com.jenifer.desarrollo_apps_android_tarea2_v2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //--------------------declaro variables--------------------------
    private EditText nombre,fecha,telefono,email,descripcion;
    private String nombre_recibido, fecha_recibido, telefono_recibido, email_recibido, descripcion_recibido;
    private int anio,mes,dia;
    private String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
    public static final String edita_nombre     ="edita_nombre";
    public static final String edita_fecha      ="edita_fecha";
    public static final String edita_telefono   ="edita_telefono";
    public static final String edita_email      ="edita_email";
    public static final String edita_descripcion="edita_descripcion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre                  =(EditText)findViewById(R.id.EditNombre);
        fecha                   =(EditText)findViewById(R.id.Fecha_Nac);
        telefono                =(EditText)findViewById(R.id.EditTelefono);
        email                   =(EditText)findViewById(R.id.EditEmail);
        descripcion             =(EditText)findViewById(R.id.EditDescripContacto);
        fecha.setInputType(InputType.TYPE_NULL);

        Intent recibido=getIntent();
        nombre_recibido         =(String)recibido.getStringExtra(edita_nombre);
        fecha_recibido          =(String)recibido.getStringExtra(edita_fecha);
        telefono_recibido       =(String)recibido.getStringExtra(edita_telefono);
        email_recibido          =(String)recibido.getStringExtra(edita_email);
        descripcion_recibido    =(String)recibido.getStringExtra(edita_descripcion);

        nombre.setText(nombre_recibido);
        fecha.setText(fecha_recibido);
        telefono.setText(telefono_recibido);
        email.setText(email_recibido);
        descripcion.setText(descripcion_recibido);



    }

    //************método Fecha***********
    public void Calendario(View view){
        Calendar calendario=Calendar.getInstance();
        anio=(int)calendario.get(Calendar.YEAR);
        mes=(int)calendario.get(Calendar.MONTH);
        dia=(int)calendario.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog selectFecha=new DatePickerDialog(MainActivity.this, R.style.Calendario, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String fechar= i2+"/"+((+i1)+1)+"/"+i;
                fecha.setText(fechar);
            }
        },2020,mes,dia);
        selectFecha.show();
    }


    //************método siguiente***********
    public void sendFeedback (View view){
        String  nombrre_string      =(String) nombre.getText().toString();
        String  fecha_string        =(String)fecha.getText().toString();
        String  telefono_string     =(String)telefono.getText().toString();
        String  email_string        =(String)email.getText().toString();
        String  descripcion_string=(String)descripcion.getText().toString();

        Intent enviar=new Intent(MainActivity.this,Confirmar.class);
        enviar.putExtra(Confirmar.dato_nombre,nombrre_string.trim());
        enviar.putExtra(Confirmar.dato_fecha,fecha_string.trim());
        enviar.putExtra(Confirmar.dato_telefono,telefono_string.trim());
        enviar.putExtra(Confirmar.dato_email,email_string.trim());
        enviar.putExtra(Confirmar.dato_descripcion,descripcion_string.trim());
        startActivity(enviar);
        finish();
        };
 }