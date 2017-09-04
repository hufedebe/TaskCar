package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.taskcar.R;
import com.taskcar.adapter.CitaList_Adapter;
import com.taskcar.data.entity.CitaEntity;

import java.util.ArrayList;

public class CitasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        final ArrayList<CitaEntity> citaLists = new ArrayList<CitaEntity>();


        //Data dummy para visualizar una cita
        citaLists.add(new CitaEntity("Javier Prado","Av. Javier Prado 5635 - La Molina","03/02/07 - 10:00am",
                                        "YX1234"));



        CitaList_Adapter adapterCita = new CitaList_Adapter(this, citaLists);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapterCita);

        TextView add_cita = (TextView) findViewById(R.id.txt_Cita);

      //  FloatingActionButton add_cita = (FloatingActionButton) findViewById(R.id.fab_add_news);


        add_cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent seleccionarVehiculo = new Intent(CitasActivity.this, SeleccionarVehiculo.class);
                seleccionarVehiculo.putExtra("TipoActividad","Servicio");
                startActivity(seleccionarVehiculo);


            }
        });



    }

    @Override
    public void onBackPressed(){

           Intent regresarMenu = new Intent(CitasActivity.this,MainActivity.class);
           startActivity(regresarMenu);

    }



}
