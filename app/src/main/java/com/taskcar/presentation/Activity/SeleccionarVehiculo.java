package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.taskcar.R;
import com.taskcar.adapter.CarList_Adapter;
import com.taskcar.data.entity.CarEntity;

import java.util.ArrayList;

public class SeleccionarVehiculo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_vehiculo);

        final ArrayList<CarEntity> carLists = new ArrayList<CarEntity>();


        //Data dummy para visualizar una cita
        carLists.add(new CarEntity("YX123","Nissan","GTL", R.drawable.ic_dcar));



        CarList_Adapter adapterCar = new CarList_Adapter(this, carLists, R.color.colorPrimary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapterCar);
        FloatingActionButton add_vehiculo = (FloatingActionButton) findViewById(R.id.fab_add_news);


        add_vehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent seleccionarVehiculo = new Intent(SeleccionarVehiculo.this, RegistrarVehiculo.class);
                startActivity(seleccionarVehiculo);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // When clicked, show a toast with the TextView text
                //Toast.makeText(SeleccionarVehiculo.this, "" + position, Toast.LENGTH_SHORT).show();


                    Intent seleccionarServicio = new Intent(SeleccionarVehiculo.this, SeleccionarServicio.class);
                    startActivity(seleccionarServicio);

            }
        });

    }
}
