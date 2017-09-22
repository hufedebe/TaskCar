package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.adapter.CarList_Adapter;
import com.taskcar.adapter.HorarioList_Adapter;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.data.entity.HorarioEntity;

import java.util.ArrayList;
import java.util.List;

public class SeleccionarFechaHora extends AppCompatActivity {

    private Button btn_generarCita;
    String init, finit, minit,mfin;
    String aperturamin, cierremin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_fecha_hora);

        Intent getResults = getIntent();
        String apertura = getResults.getStringExtra("apertura");

        String cierre = getResults.getStringExtra("cierre");
        String atenciones = getResults.getStringExtra("atenciones");
        //String horario = getResults.getStringExtra("horario");


        init=apertura.substring(0,2);
        minit=apertura.substring(3,5);

        finit= cierre.substring(0,2);
        mfin=cierre.substring(3,5);
      //  mfin= cierre.substring(3,2);



        int vinit = Integer.parseInt(init);
        int vminit = Integer.parseInt(minit);

        int vfinit = Integer.parseInt(finit);
        int vmfin = Integer.parseInt(mfin);

        final ArrayList<HorarioEntity> horarioList = new ArrayList<HorarioEntity>();
        Integer minutos = vminit;

        for(Integer i=vinit;i<=vfinit;i++){


            do{
                Integer flag = minutos +15;
                if (minutos==0) {
                    horarioList.add(new HorarioEntity((i.toString() + ":" + minutos.toString()+"0" + " - " + i.toString() + ":" + flag.toString())));
                }else{
                    horarioList.add(new HorarioEntity((i.toString() + ":" + minutos.toString() + " - " + i.toString() + ":" + flag.toString())));

                }

                minutos = minutos +15;
            }while((minutos+15)<=45);

            Integer valor =i+1;
            Integer flag2 = 60-(minutos+15);
            //minutos = 60-minutos;

            if(flag2==0){
                horarioList.add(new HorarioEntity((i.toString()+":"+minutos.toString()+" - "+ valor.toString()+":"+ flag2.toString()+"0" )));

            }else{
                horarioList.add(new HorarioEntity((i.toString()+":"+minutos.toString()+" - "+ valor.toString()+":"+ flag2.toString() )));

            }

            minutos=flag2;
        }



        //Toast.makeText(getApplicationContext(),horarios.get(2), Toast.LENGTH_LONG).show();
        final HorarioList_Adapter adapterHorario = new HorarioList_Adapter(this, horarioList);

        ListView listView = (ListView) findViewById(R.id.list);



        listView.setAdapter(adapterHorario);




        btn_generarCita = (Button) findViewById(R.id.btn_generarCita);

        btn_generarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer positiond=adapterHorario.selectedPosition;

                String data = horarioList.get(positiond).getHorario();

                //Toast.makeText(SeleccionarFechaHora.this,minit, Toast.LENGTH_SHORT).show();

                btn_generarCita.setBackgroundColor(Color.parseColor("#B71C1C"));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    finishAffinity();
                }
                Intent intent = new Intent(SeleccionarFechaHora.this, CitasActivity.class);
                startActivity(intent);
            }
        });

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
