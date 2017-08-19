package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.taskcar.R;
import com.taskcar.RegisterSubActivity;

public class Observaciones extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observaciones);

        LinearLayout tipo_mantenimiento = (LinearLayout) findViewById(R.id.tipo_mantenimiento);
        final Button btn_continuar = (Button) findViewById(R.id.btn_continuar);
/*
        if (tipoMantenimiento==false){
            tipo_mantenimiento.setVisibility(View.VISIBLE);
        }else {
            tipo_mantenimiento.setVisibility(View.GONE);
        }
*/

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
