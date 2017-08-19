package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.taskcar.R;

public class SeleccionarFechaHora extends AppCompatActivity {

    private Button btn_generarCita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_fecha_hora);

        btn_generarCita = (Button) findViewById(R.id.btn_generarCita);

        btn_generarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_generarCita.setBackgroundColor(Color.parseColor("#B71C1C"));
                Intent intent = new Intent(SeleccionarFechaHora.this, CitasActivity.class);
                startActivity(intent);
            }
        });



    }
}
