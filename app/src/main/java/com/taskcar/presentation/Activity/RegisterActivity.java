package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.DVisualizarVehicle;
import com.taskcar.R;
import com.taskcar.db.model.Car;
import com.taskcar.model.LoginPost;
import com.taskcar.model.VehiculoPost;
import com.taskcar.retrofit.AtencionVehicularAdapter;
import com.taskcar.retrofit.Response.LoginResponse;
import com.taskcar.retrofit.Response.RegistroResponse;
import com.taskcar.retrofit.Response.VehiculoResponse;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements SensorEventListener {


    public static String dniUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView registrarse = (TextView) findViewById(R.id.link_create);
        Button login = (Button)findViewById(R.id.btn_login);

        final TextView usuario = (TextView) findViewById(R.id.input_usuario);
        final TextView password = (TextView) findViewById(R.id.input_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    RegisterMainActivity.dniUsuario="";
                    dniUsuario = usuario.getText().toString();
                    LoginPost loginPersona = new LoginPost(usuario.getText().toString(),password.getText().toString());
                    Call<LoginResponse> call = AtencionVehicularAdapter.getApiService().postLoginPersona(loginPersona);
                    call.enqueue(new LoginPersonaCallback());


            }
        });


        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerMain = new Intent(RegisterActivity.this, RegisterMainActivity.class);
                startActivity(registerMain);
            }
        });


    }


    class LoginPersonaCallback implements  Callback<LoginResponse>{


        @Override
        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
            if(response.isSuccessful()){
                LoginResponse loginResponse = response.body();
                if (loginResponse.getMensaje().getStatus()==200){

                    Toast.makeText(getApplicationContext(),"Inicio de Sesión Correcta", Toast.LENGTH_SHORT).show();
                    MainActivity.ingreso= true;
                    Intent loguearse  = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(loguearse);

                }else{
                    dniUsuario="";
                    Toast.makeText(getApplicationContext(),"Verifique los datos Ingresados", Toast.LENGTH_SHORT).show();
                }


            }else{
                dniUsuario="";
                Toast.makeText(getApplicationContext(),"Problemas Conexion", Toast.LENGTH_SHORT).show();


            }

        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {

        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
