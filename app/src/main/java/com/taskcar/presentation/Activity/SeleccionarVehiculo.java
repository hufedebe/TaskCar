package com.taskcar.presentation.Activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.taskcar.R;
import com.taskcar.adapter.CarList_Adapter;
import com.taskcar.data.entity.CarEntity;
import com.taskcar.db.helper.DatabaseHelper;
import com.taskcar.db.model.Car;

import java.util.ArrayList;
import java.util.List;

public class SeleccionarVehiculo extends AppCompatActivity {

    private ArrayList<Car> carLists = new ArrayList<Car>();
    final DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_vehiculo);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Data dummy para visualizar una cita

        carLists.clear();
        carLists.addAll(db.getAllCars());

        //carLists.add(new CarEntity("YX123","Nissan","GTL", R.drawable.ic_dcar));



        CarList_Adapter adapterCar = new CarList_Adapter(this, carLists);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapterCar);

        //Floating Buttont
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



    private ArrayList<Car> getCarList() {

        List<Car> cars = db.getAllCars();

        for (Car cn : cars) {

            Car car = new Car();
            car.setPlaca(cn.getPlaca());
            car.setMarca(cn.getMarca());
            car.setModelo(cn.getModelo());

            carLists.add(car);
        }
        return carLists;
    }


}
