package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.model.Servicio;
import com.taskcar.retrofit.AtencionVehicularAdapter;
import com.taskcar.retrofit.Response.ServiciosResponse;
import com.taskcar.retrofit.Response.TalleresResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.FacebookSdk.getApplicationContext;
import static java.security.AccessController.getContext;

public class Observaciones extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Boolean mantenimiento;

    public static Integer tipoServicio;
    final ArrayList<Servicio> servicioList = new ArrayList<Servicio>();
    ArrayAdapter<String> dataAdapter;
    private List<String> serviceList = new ArrayList<>();
    //List<String> listaServicios  ;
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
        obtenerServicios();

        spinner = (Spinner) findViewById(R.id.servicios_spinner);


        loadSpinnerData();
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

       if (firstValue.equals("1")) {
           tipo_mantenimiento.setVisibility(View.VISIBLE);
           mantenimiento= true;
       }

        if (thirdValue.equals("1")) {
            tipo_mantenimiento.setVisibility(View.VISIBLE);
            mantenimiento = true;
        }

        if (secondValue.equals("1")) {
            tipo_mantenimiento.setVisibility(View.VISIBLE);
            mantenimiento = false;
        }

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_continuar.setBackgroundColor(Color.parseColor("#B71C1C"));
                Intent continuar = new Intent(Observaciones.this,SeleccionarTaller.class);

                startActivity(continuar);
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

    private void obtenerServicios(){
        Call<ServiciosResponse> call = AtencionVehicularAdapter.getApiService().getServicios();
        call.enqueue(new ServiciosCallback());
    }
    private void poblarListaServicios(List<Servicio> servicios){
        serviceList.clear();
        servicioList.clear();
        String bandera;
        for (Servicio r: servicios){
            bandera=r.getNombreServicio();
            bandera=bandera.substring(0,2);
            //Toast.makeText(getApplicationContext(),bandera, Toast.LENGTH_SHORT).show();
            if(mantenimiento){

                if(bandera.equals("Ma")){
                    servicioList.add(new Servicio(r.getNombreServicio(),r.getIdServicio()));
                    serviceList.add(r.getNombreServicio());
                }

            }else{
                if(!bandera.equals("Ma")){
                    servicioList.add(new Servicio(r.getNombreServicio(),r.getIdServicio()));
                    serviceList.add(r.getNombreServicio());
                }
            }



        }
        dataAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();
       // ((TextView) view).setTextColor(Color.RED);
        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "You selected: " + label, Toast.LENGTH_LONG).show();
        tipoServicio=servicioList.get(position).getIdServicio();
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    class  ServiciosCallback implements Callback<ServiciosResponse>{


        @Override
        public void onResponse(Call<ServiciosResponse> call, Response<ServiciosResponse> response) {
            if (response.isSuccessful()){
                ServiciosResponse serviciosResponse = response.body();
                poblarListaServicios(serviciosResponse.getServicios());

            }else{
                Toast.makeText(getApplicationContext(),"Error en el formato ", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<ServiciosResponse> call, Throwable t) {

        }
    }

    private void loadSpinnerData() {

        // Spinner Drop down elements
        //List<String> lables = db.getAllLabels();
        //serviceList.add("hugo");
        // Creating adapter for spinner
         dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, serviceList);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

}
