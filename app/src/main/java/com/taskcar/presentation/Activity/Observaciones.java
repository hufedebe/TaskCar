package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.taskcar.R;

public class Observaciones extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observaciones);

        Intent getResults = getIntent();
        String firstValue = getResults.getStringExtra("key1");
        String secondValue = getResults.getStringExtra("key2");
        String thirdValue = getResults.getStringExtra("key3");
        //int value = getIntent().getExtras().getInt("Mantenimiento");

        LinearLayout tipo_mantenimiento = (LinearLayout) findViewById(R.id.tipo_mantenimiento);
        final Button btn_continuar = (Button) findViewById(R.id.btn_continuar);
        Toast.makeText(Observaciones.this,secondValue, Toast.LENGTH_SHORT).show();

       if (firstValue.equals("1")) {
           tipo_mantenimiento.setVisibility(View.VISIBLE);
       }

        if (thirdValue.equals("1")) {
            tipo_mantenimiento.setVisibility(View.VISIBLE);
        }

        if (secondValue.equals("1")) {
            tipo_mantenimiento.setVisibility(View.GONE);
        }

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_continuar.setBackgroundColor(Color.parseColor("#B71C1C"));
                Intent continuar = new Intent(Observaciones.this,SeleccionarTaller.class);

                startActivity(continuar);
            }
        });




    }
}
