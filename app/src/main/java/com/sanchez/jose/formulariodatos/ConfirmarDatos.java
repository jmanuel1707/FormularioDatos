package com.sanchez.jose.formulariodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {


    String nombre;
    String fechaNacimiento;
    String telefono;
    String email;
    String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString("Nombre");
        fechaNacimiento = parametros.getString("FechaNacimiento");
        telefono = parametros.getString("Telefono");
        email = parametros.getString("Email");
        descripcion = parametros.getString("Descripcion");

        TextView tvNombre = (TextView) findViewById(R.id.nombreCompletoConfirmar);
        tvNombre.setText(nombre);

        TextView tvfechaNacimiento = (TextView) findViewById(R.id.fechaNacimientoConfirmar);
        tvfechaNacimiento.setText(fechaNacimiento);

        TextView tvtelefono = (TextView) findViewById(R.id.telefonoConfirmar);
        tvtelefono.setText(telefono);

        TextView tvEmail = (TextView) findViewById(R.id.emailConfirmar);
        tvEmail.setText(email);

        TextView tvDescripcion = (TextView) findViewById(R.id.descripcionConfirmar);
        tvDescripcion.setText(descripcion);


        Button botonRegresar = (Button) findViewById(R.id.boton_regresar);
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra("Nombre",nombre);
                intent.putExtra("FechaNacimiento",fechaNacimiento);
                intent.putExtra("Telefono",telefono);
                intent.putExtra("Email",email);
                intent.putExtra("Descripcion",descripcion);
                startActivity(intent);
                finish();
            }
        });




    }
}
