package com.taskcar.presentation.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

    final ArrayList<Historia> eventoList = new ArrayList<>();
    final DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_vehicular);

        obtenerHistoriaVehicular();
        eventoList.clear();
        eventoList.addAll(db.getAllHistoriaDNI("71918340"));

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
        Call<ListarEventosResponse> call = AtencionVehicularAdapter.getApiService().geListarEventos("QWE105");
        call.enqueue(new ListarEventosCallback());
    }

    private void poblarHistoriaVehicular(List<Evento> eventos){


        String bandera;
        for (Evento r: eventos){
            if (r.getEstadoEvento()=="5"){

              Cita cita =  db.getAllCitasIdEvento(r.getIdEvento().toString());
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
