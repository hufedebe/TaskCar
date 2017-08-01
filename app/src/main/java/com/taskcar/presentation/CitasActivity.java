package com.taskcar.presentation;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.adapter.CitaList_Adapter;
import com.taskcar.data.entity.CitaEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class CitasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        final ArrayList<CitaEntity> citaLists = new ArrayList<CitaEntity>();


        //Data dummy para visualizar una cita
        citaLists.add(new CitaEntity("Javier Prado","Av. Javier Prado 5635 - La Molina","03/02/07 - 10:00am",
                                        "YX1234", R.drawable.ic_date));



        CitaList_Adapter adapterCita = new CitaList_Adapter(this, citaLists, R.color.colorPrimary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapterCita);



        FloatingActionButton add_cita = (FloatingActionButton) findViewById(R.id.fab_add_news);


        add_cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent seleccionarVehiculo = new Intent(CitasActivity.this, SeleccionarVehiculo.class);
                startActivity(seleccionarVehiculo);


            }
        });

    }




}
