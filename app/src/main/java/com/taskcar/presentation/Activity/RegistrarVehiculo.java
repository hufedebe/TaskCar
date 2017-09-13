package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.db.helper.DatabaseHelper;
import com.taskcar.db.model.Car;
import com.taskcar.model.VehiculoPost;
import com.taskcar.retrofit.AtencionVehicularAdapter;
import com.taskcar.retrofit.Response.VehiculoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarVehiculo extends AppCompatActivity implements OnItemSelectedListener {

    private EditText marcaVehiculo, modeloVehiculo, placaVehiculo;
    String textMarca;
    String textModelo;
    Button registrarVehiculo;
    Spinner spineerVehiculo, spinnerModeloVehiculo;
    ArrayAdapter<String> changanAdapter;
    ArrayAdapter<String> citroenAdapter;
    ArrayAdapter<String> dsAdapter;
    ArrayAdapter<String> fotonAdapter;
    ArrayAdapter<String> greatwallAdapter;
    ArrayAdapter<String> havalAdapter;
    ArrayAdapter<String> jacAdapter;
    ArrayAdapter<String> mazdaAdapter;
    ArrayAdapter<String> suzukiAdapter;
    final DatabaseHelper db = new DatabaseHelper(this);


    String[] changan = {"Benni","Changancs75"};

    String[] citroen = {"Berlingo","C4","C4 Cactus", "Celysse"};

    String[] ds = {"DS2","DS4"};

    String[] foton = {"Sauvana"};

    String[] greatWall = {"C30","M4","Wingle-5"};

    String[] haval = {"H2","H6"};

    String[] jac = {"J4","Refine", "S3", "S5"};

    String[] mazda = {"Mazda-3","Mazda-5","Mazda-CX-5","Mazda-CX-9"};

    String[] suzuki = {"All New Celerio", "APV Furgon", "Grand Nomade", "Grand Vitara", "Swift 1.4", "Swift Sedan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_vehiculo);



        spineerVehiculo = (Spinner) findViewById(R.id.marca_spinner);
        spinnerModeloVehiculo = (Spinner) findViewById(R.id.modelo_spinner);

        spineerVehiculo.setOnItemSelectedListener(this);



        changanAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, changan);
        changanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        citroenAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, citroen);
        citroenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ds);
        dsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fotonAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, foton);
        fotonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        greatwallAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, greatWall);
        greatwallAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        havalAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, haval);
        havalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        jacAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, jac);
        jacAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mazdaAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mazda);
        mazdaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        suzukiAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, suzuki);
        suzukiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //final String textMarca = spinnerVehiculo.getSelectedItem().toString();
       // TextView textView = (TextView)spinnerVehiculo.getSelectedView();
        //final String textMarca = textView.getText().toString();


        //marcaVehiculo = (EditText) findViewById(R.id.marca_vehiculo);
        //modeloVehiculo = (EditText) findViewById(R.id.modelo_vehiculo);
        placaVehiculo= (EditText) findViewById(R.id.placa_vehiculo);

        registrarVehiculo = (Button) findViewById(R.id.btn_Registrar_Vehiculo);


        registrarVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // final String textMarca = spinnerVehiculo.getSelectedItem().toString();
                //String textMarca = registrarVehiculo.getTag().toString();
                textModelo = spinnerModeloVehiculo.getSelectedItem().toString();
                VehiculoPost vehiculo2 = new VehiculoPost(placaVehiculo.getText().toString(),"12345678","1","1","1996");
                Call<VehiculoResponse> call = AtencionVehicularAdapter.getApiService().postRegistrarVehiculo(vehiculo2);
                call.enqueue(new RegistrarVehiculoCallback());



            }
        });

    }

    class RegistrarVehiculoCallback implements Callback<VehiculoResponse>{


        @Override
        public void onResponse(Call<VehiculoResponse> call, Response<VehiculoResponse> response) {
            if(response.isSuccessful()){
                VehiculoResponse vehiculoResponse = response.body();
                if (vehiculoResponse.getMensaje().getStatus()==200){
                    db.addCar(new Car(placaVehiculo.getText().toString(), textMarca,textModelo));
                    Toast.makeText(getApplicationContext(),"Se registró correctamente ", Toast.LENGTH_SHORT).show();

                    Intent seleccionarVehiculo = new Intent(RegistrarVehiculo.this, SeleccionarVehiculo.class);
                    startActivity(seleccionarVehiculo);
                }else{
                    Log.i("Retrofit", "post submitted to API." + response.body().toString());
                    Toast.makeText(getApplicationContext(),vehiculoResponse.getMensaje().getStatus().toString(), Toast.LENGTH_SHORT).show();
                }


            }else{
                Toast.makeText(getApplicationContext(),"Problemas Conexion", Toast.LENGTH_SHORT).show();


            }

        }

        @Override
        public void onFailure(Call<VehiculoResponse> call, Throwable t) {
            Toast.makeText(getApplicationContext(),"Error en la estructura", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        textMarca = spineerVehiculo.getSelectedItem().toString();
        if(position == 1){
            spinnerModeloVehiculo.setAdapter(changanAdapter);
        }else if (position==2){
            spinnerModeloVehiculo.setAdapter(citroenAdapter);
        }else if (position==3){
            spinnerModeloVehiculo.setAdapter(dsAdapter);
        }else if (position==4){
            spinnerModeloVehiculo.setAdapter(fotonAdapter);
        }else if (position==5){
            spinnerModeloVehiculo.setAdapter(greatwallAdapter);
        }else if (position==6){
            spinnerModeloVehiculo.setAdapter(havalAdapter);
        }else if (position==7){
            spinnerModeloVehiculo.setAdapter(jacAdapter);
        }else if (position==8){
            spinnerModeloVehiculo.setAdapter(mazdaAdapter);
        }else if (position==9){
            spinnerModeloVehiculo.setAdapter(suzukiAdapter);
        }

        }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
