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
import com.taskcar.adapter.CarList_Adapter;
import com.taskcar.adapter.CitaList_Adapter;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.db.helper.DatabaseHelper;
import com.taskcar.db.model.Car;
import com.taskcar.db.model.Cita;

import java.util.ArrayList;

public class CitasActivity extends AppCompatActivity {

    private ArrayList<Cita> citaLists = new ArrayList<Cita>();
    final DatabaseHelper db = new DatabaseHelper(this);
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

        String usuario;
        if (RegisterMainActivity.dniUsuario!=null && !RegisterMainActivity.dniUsuario.isEmpty()){
            usuario = RegisterMainActivity.dniUsuario;
        }else if(RegisterActivity.dniUsuario!=null && !RegisterActivity.dniUsuario.isEmpty()){
            usuario = RegisterActivity.dniUsuario;
        }else{
            usuario = "12345678";
        }
       // final ArrayList<CitaEntity> citaLists = new ArrayList<CitaEntity>();



        //Data dummy para visualizar una cita
        //citaLists.add(new CitaEntity("Javier Prado","Av. Javier Prado 5635 - La Molina","03/02/07 - 10:00am",
         //                               "YX1234"));

        citaLists.clear();
        citaLists.addAll(db.getAllCitasDNI(usuario));

        //carLists.add(new CarEntity("YX123","Nissan","GTL", R.drawable.ic_dcar));



     //   CarList_Adapter adapterCar = new CarList_Adapter(this, citaLists);


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
