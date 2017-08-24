package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.taskcar.R;
import com.taskcar.VehiculosActivity;

public class RegisterSubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_sub);

        Button btn_vehiculo = (Button) findViewById(R.id.btn_vehiculo);
        Button btn_cita = (Button) findViewById(R.id.btn_cita);
        Button btn_taller = (Button) findViewById(R.id.btn_taller);
        ImageView btn_inicio = (ImageView) findViewById(R.id.btn_inicio);

        btn_vehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vehiculoActivity = new Intent(RegisterSubActivity.this, SeleccionarVehiculo.class);
                startActivity(vehiculoActivity);
            }
        });

        btn_cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent citaActivity = new Intent(RegisterSubActivity.this, CitasActivity.class);
                startActivity(citaActivity);
            }
        });

        btn_taller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tallerActivity = new Intent(RegisterSubActivity.this, SeleccionarTaller.class);
                startActivity(tallerActivity);
            }
        });


        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicioActivity = new Intent(RegisterSubActivity.this, MainActivity.class);
                startActivity(inicioActivity);
            }
        });
    }
}
