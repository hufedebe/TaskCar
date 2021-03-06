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
import android.widget.TextView;
import android.widget.Toast;

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
    public String placa_Cita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_vehiculo);
        String usuario;
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView agregarAuto = (TextView) findViewById(R.id.txt_AgregarAuto);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Data dummy para visualizar una cita
        if (RegisterMainActivity.dniUsuario!=null && !RegisterMainActivity.dniUsuario.isEmpty()){
            usuario = RegisterMainActivity.dniUsuario;
        }else if(RegisterActivity.dniUsuario!=null && !RegisterActivity.dniUsuario.isEmpty()){
            usuario = RegisterActivity.dniUsuario;
        }else{
            usuario = "12345678";
        }
        //Toast.makeText(getApplicationContext(),usuario, Toast.LENGTH_LONG).show();
        carLists.clear();
        carLists.addAll(db.getAllCarsDNI(usuario));

        //carLists.add(new CarEntity("YX123","Nissan","GTL", R.drawable.ic_dcar));



        final CarList_Adapter adapterCar = new CarList_Adapter(this, carLists);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapterCar);

        //Floating Buttont
        //FloatingActionButton add_vehiculo = (FloatingActionButton) findViewById(R.id.fab_add_news);
        agregarAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seleccionarVehiculo = new Intent(SeleccionarVehiculo.this, RegistrarVehiculo.class);
                startActivity(seleccionarVehiculo);
            }
        });


/*
        add_vehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent seleccionarVehiculo = new Intent(SeleccionarVehiculo.this, RegistrarVehiculo.class);
                startActivity(seleccionarVehiculo);

            }
        });
*/
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int c, long id) {
                // When clicked, show a toast with the TextView text
                //Toast.makeText(SeleccionarVehiculo.this, "" + position, Toast.LENGTH_SHORT).show();


                //String data = carLists.get(position).getHorario();

                    Intent seleccionarServicio = new Intent(SeleccionarVehiculo.this, SeleccionarServicio.class);
                    startActivity(seleccionarServicio);

            }
        });*/

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

    @Override
    public void onBackPressed(){
        Intent regresarMenu = new Intent(SeleccionarVehiculo.this,CitasActivity.class);
        startActivity(regresarMenu);

    }


}
