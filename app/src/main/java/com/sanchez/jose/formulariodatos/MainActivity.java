package com.sanchez.jose.formulariodatos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    TextView nombre;
    TextView fechaNacimiento;
    TextView telefono;
    TextView email;
    TextView descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = (TextView) findViewById(R.id.textView3);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);


        nombre = (TextView) findViewById(R.id.nombreCompleto);
        fechaNacimiento = (TextView) findViewById(R.id.textView3);
        telefono = (TextView) findViewById(R.id.telefono);
        email = (TextView) findViewById(R.id.email);
        descripcion = (TextView) findViewById(R.id.descripcion);



        if(getIntent() != null && getIntent().getExtras() != null){
            Bundle parametros = getIntent().getExtras();

            String nombreRegresar = parametros.getString("Nombre");
            String fechaNacimientoRegresar = parametros.getString("FechaNacimiento");
            String telefonoRegresar = parametros.getString("Telefono");
            String emailRegresar = parametros.getString("Email");
            String descripcionRegresar = parametros.getString("Descripcion");

            nombre.setText(nombreRegresar);
            fechaNacimiento.setText(fechaNacimientoRegresar);
            telefono.setText(telefonoRegresar);
            email.setText(emailRegresar);
            descripcion.setText(descripcionRegresar);
        }



        Button boton = (Button) findViewById(R.id.boton_siguiente);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra("Nombre",nombre.getText().toString());
                intent.putExtra("FechaNacimiento",fechaNacimiento.getText().toString());
                intent.putExtra("Telefono",telefono.getText().toString());
                intent.putExtra("Email",email.getText().toString());
                intent.putExtra("Descripcion",descripcion.getText().toString());

                startActivity(intent);
                finish();
            }
        });


    }



    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {

                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }



}
