package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.taskcar.R;

public class RegistrarVehiculo extends AppCompatActivity {

    private EditText marcaVehiculo, modeloVehiculo, placaVehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_vehiculo);

        marcaVehiculo = (EditText) findViewById(R.id.marca_vehiculo);
        modeloVehiculo = (EditText) findViewById(R.id.modelo_vehiculo);
        placaVehiculo= (EditText) findViewById(R.id.placa_vehiculo);

        Button registrarVehiculo = (Button) findViewById(R.id.btn_Registrar_Vehiculo);


        registrarVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seleccionarVehiculo = new Intent(RegistrarVehiculo.this, SeleccionarVehiculo.class);
                startActivity(seleccionarVehiculo);


            }
        });



    }
}
