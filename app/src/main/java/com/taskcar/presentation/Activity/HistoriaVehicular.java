package com.taskcar.presentation.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.adapter.HistoriaVehicularList_Adapter;
import com.taskcar.db.helper.DatabaseHelper;
import com.taskcar.db.model.Cita;
import com.taskcar.db.model.Historia;
import com.taskcar.model.Evento;
import com.taskcar.retrofit.AtencionVehicularAdapter;
import com.taskcar.retrofit.Response.ListarEventosResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoriaVehicular extends AppCompatActivity {

    final ArrayList<Historia> eventoList = new ArrayList<Historia>();
    final DatabaseHelper db = new DatabaseHelper(this);
    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_historia_vehicular);
        if (RegisterMainActivity.dniUsuario!=null && !RegisterMainActivity.dniUsuario.isEmpty()){
            usuario = RegisterMainActivity.dniUsuario;
        }else if(RegisterActivity.dniUsuario!=null && !RegisterActivity.dniUsuario.isEmpty()){
            usuario = RegisterActivity.dniUsuario;
        }else{
            usuario = "12345678";
        }
        obtenerHistoriaVehicular();
        Log.d("Usuario H ", usuario);
        eventoList.clear();
        eventoList.addAll(db.getAllHistoriaDNI(SeleccionarServicio.placa));


        HistoriaVehicularList_Adapter adapter_Hitoria = new HistoriaVehicularList_Adapter(this, eventoList);

        ListView listView = (ListView) findViewById(R.id.list_historiaVehicular);
        listView.setAdapter(adapter_Hitoria);


        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }

    private void obtenerHistoriaVehicular(){
        Call<ListarEventosResponse> call = AtencionVehicularAdapter.getApiService().geListarEventos(SeleccionarServicio.placa);
        call.enqueue(new ListarEventosCallback());
    }

    private void poblarHistoriaVehicular(List<Evento> eventos){


        for (Evento r: eventos){
            if (r.getEstadoEvento().equals("5")){

                Cita cita = null;
                cita =  db.getAllCitasIdEvento(r.getIdEvento().toString());
                //Log.d("goool", cita.getDni());
                if(cita ==null) {
                    Log.d("getTasksListHTTP", "Evento Fallado");
                }else{
                    Log.d("getTasksListHTTP", "Evento Confirmado");
                    Historia historia = new Historia();

                    historia.setIdEvento(cita.getIdEvento());
                    historia.setDni(cita.getDni());
                    historia.setIdTaller(cita.getIdTaller());
                    historia.setNombreTaller(cita.getNombreTaller());
                    historia.setPlaca(cita.getPlaca());
                    historia.setDireccionTaller(cita.getDireccionTaller());
                    historia.setDiaHoraEvento(cita.getDiaHoraEvento());
                    historia.setIdServicio(cita.getIdServicio());
                    historia.setTipoServicio(cita.getTipoServicio());
                    historia.setPuntuacion("0");

                    db.addHistoria(historia);
                    db.deleteCita(cita);

                }


            }

        }


    }

    class ListarEventosCallback implements Callback<ListarEventosResponse>{

        @Override
        public void onResponse(Call<ListarEventosResponse> call, Response<ListarEventosResponse> response) {
            if (response.isSuccessful()){
                ListarEventosResponse eventosResponse = response.body();
                poblarHistoriaVehicular(eventosResponse.getEventos());
                //poblarListaTalleres(talleresResponse.getTalleres());

            }else{
                Toast.makeText(getApplicationContext(),"Error en el formato ", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<ListarEventosResponse> call, Throwable t) {

        }
    }
}
