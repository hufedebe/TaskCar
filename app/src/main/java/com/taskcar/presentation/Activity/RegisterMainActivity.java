package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.db.model.Car;
import com.taskcar.model.RegistroPost;
import com.taskcar.model.VehiculoPost;
import com.taskcar.retrofit.AtencionVehicularAdapter;
import com.taskcar.retrofit.Response.RegistroResponse;
import com.taskcar.retrofit.Response.VehiculoResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterMainActivity extends AppCompatActivity {

    public static String dniUsuario;
    public static String nombreUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_main);

        final EditText nombre = (EditText) findViewById(R.id.input_nombre);
        final EditText apellidoPaterno = (EditText) findViewById(R.id.input_apellidos);
        final EditText apellidoMaterno = (EditText) findViewById(R.id.input_apellido_materno);
        final EditText dni = (EditText) findViewById(R.id.input_dni);
        final EditText  telefono = (EditText) findViewById(R.id.input_telefono);
        final EditText direccion = (EditText) findViewById(R.id.input_direccion);
        final EditText email = (EditText) findViewById(R.id.input_email);
        final EditText contrasena = (EditText) findViewById(R.id.input_contrasena);


        Button register = (Button) findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dniUsuario=dni.getText().toString();
                nombreUsuario=nombre.getText().toString();
                RegistroPost registroPost = new RegistroPost(nombre.getText().toString(),apellidoPaterno.getText().toString(),apellidoMaterno.getText().toString(),
                                                            dni.getText().toString(),telefono.getText().toString(),direccion.getText().toString(),email.getText().toString(),
                                                            contrasena.getText().toString());
                Call<RegistroResponse> call = AtencionVehicularAdapter.getApiService().postRegistrarPersona(registroPost);
                call.enqueue(new RegistrarPersonaCallback());



            }
        });

    }

    class RegistrarPersonaCallback implements Callback<RegistroResponse>{

        @Override
        public void onResponse(Call<RegistroResponse> call, Response<RegistroResponse> response) {
            if(response.isSuccessful()){
                RegistroResponse registroResponse = response.body();
                if (registroResponse.getMensaje().getStatus()==200){

                    Toast.makeText(getApplicationContext(),"Se registró correctamente ", Toast.LENGTH_SHORT).show();
                    Intent register = new Intent(RegisterMainActivity.this,RegisterSubActivity.class);
                    startActivity(register);

                }else{
                    dniUsuario="";
                    nombreUsuario="";
                   // Log.i("Retrofit", "post submitted to API." + response.body().toString());
                    Toast.makeText(getApplicationContext(),"Registro Erroneo", Toast.LENGTH_SHORT).show();
                }


            }else{
                dniUsuario="";
                nombreUsuario="";
                Toast.makeText(getApplicationContext(),"Problemas Conexion", Toast.LENGTH_SHORT).show();


            }
        }

        @Override
        public void onFailure(Call<RegistroResponse> call, Throwable t) {

        }
    }
}
