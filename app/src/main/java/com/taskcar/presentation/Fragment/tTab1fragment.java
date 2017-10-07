package com.taskcar.presentation.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.adapter.TallerList_Adapter;
import com.taskcar.data.entity.tallerEntity;
import com.taskcar.db.model.Car;
import com.taskcar.model.Taller;
import com.taskcar.presentation.Activity.Observaciones;
import com.taskcar.presentation.Activity.RegisterActivity;
import com.taskcar.presentation.Activity.RegisterMainActivity;
import com.taskcar.presentation.Activity.SeleccionarFechaHora;
import com.taskcar.presentation.Activity.SeleccionarServicio;
import com.taskcar.presentation.Activity.SeleccionarTaller;
import com.taskcar.presentation.Activity.SeleccionarVehiculo;
import com.taskcar.retrofit.AtencionVehicularAdapter;
import com.taskcar.retrofit.Response.TalleresResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Hudeya on 2/08/2017.
 */

public class tTab1fragment extends Fragment {

    private static final String TAG = "TAB1Fragment";
    final ArrayList<Taller> tallerLists = new ArrayList<Taller>();
     ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ttab1_fragment,container,false);

        obtenerDatosTalleres();

        return view;
    }

    private void obtenerDatosTalleres(){
        Call<TalleresResponse> call = AtencionVehicularAdapter.getApiService().getTalleres();
        call.enqueue(new TalleresCallback());
    }

    private void poblarListaTalleres(ArrayList<Taller> talleres){
        tallerLists.clear();
        String aperturaNoctuno;
        String cierreNocturno;
        String aperturaExpress;
        Integer atencionesExpress;
        String aperturaDiurno;
        Integer atencionesNocturno;
        String cierreExpress;
        Integer atencionesDiurno;
        String cierreDiurno;
        Integer puntuacion;
        for (Taller r: talleres){


            if (r.getAperturaNocturno()!=null && !r.getAperturaNocturno().isEmpty()) {
                aperturaNoctuno= r.getAperturaNocturno();
            }else{
                aperturaNoctuno="00:00:00";
            }

            if (r.getCierreNocturno()!=null && !r.getCierreNocturno().isEmpty()) {
                cierreNocturno= r.getCierreNocturno();
            }else{
                cierreNocturno="00:00:00";
            }

            if (r.getAperturaExpress()!=null && !r.getAperturaExpress().isEmpty()) {
                aperturaExpress= r.getAperturaExpress();
            }else{
                aperturaExpress="00:00:00";
            }

            if (r.getAtencionesExpress()!=null) {
                atencionesExpress= r.getAtencionesExpress();
            }else{
                atencionesExpress=0;
            }

            if (r.getAperturaDiurno()!=null && !r.getAperturaDiurno().isEmpty()) {
                aperturaDiurno= r.getAperturaDiurno();
            }else{
                aperturaDiurno="00:00:00";
            }

            if (r.getAtencionesNocturno()!=null) {
                atencionesNocturno= r.getAtencionesNocturno();
            }else{
                atencionesNocturno=0;
            }

            if (r.getPuntuacion()!=null) {
                puntuacion= r.getPuntuacion();
            }else{
                puntuacion=0;
            }
            if (r.getCierreExpress()!=null && !r.getCierreExpress().isEmpty()) {
                cierreExpress= r.getCierreExpress();
            }else{
                cierreExpress="00:00:00";
            }
            if (r.getAtencionesDiurno()!=null) {
                atencionesDiurno= r.getAtencionesDiurno();
            }else{
                atencionesDiurno=0;
            }
            if (r.getCierreDiurno()!=null && !r.getCierreDiurno().isEmpty()) {
                cierreDiurno= r.getCierreDiurno();
            }else{
                cierreDiurno="00:00:00";
            }
            tallerLists.add(new Taller(aperturaNoctuno,r.getLatitud(),cierreNocturno,
                                            r.getTelefonoTaller(),aperturaExpress,atencionesExpress,
                                            aperturaDiurno,atencionesNocturno,cierreExpress,
                                            r.getNombreTaller(),r.getLongitud(),puntuacion,atencionesDiurno, r.getDireccionTaller(),
                                            r.getIdTaller(),cierreDiurno));

        }
        final TallerList_Adapter adapterTaller = new TallerList_Adapter(getView().getContext(), tallerLists);
        Log.d("getTasksListHTTP", "Taller" + tallerLists.toString());
        listView = (ListView) getView().findViewById(R.id.list);
        listView.setAdapter(adapterTaller);
/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
               // Toast.makeText(getApplicationContext(),"Si selecciona ", Toast.LENGTH_SHORT).show();
                final Taller currentTaller = (Taller) adapterTaller.getItem(position);
                Intent taller = new Intent(getActivity(), SeleccionarFechaHora.class);
               // taller.putExtra("apertura",currentTaller.getAperturaDiurno());
                //taller.putExtra("idTaller",currentTaller.getIdTaller().toString());
                //taller.putExtra("nombreTaller",currentTaller.getNombreTaller());
                //taller.putExtra("direccionTaller",currentTaller.getDireccionTaller());

                Log.d("getTasksListHTTP", "Taller" + currentTaller.getNombreTaller());
                getActivity().startActivity(taller);
            }
        });
*/
    }


    class TalleresCallback implements Callback<TalleresResponse> {

        @Override
        public void onResponse(Call<TalleresResponse> call, Response<TalleresResponse> response) {
            if (response.isSuccessful()){
                TalleresResponse talleresResponse = response.body();
                poblarListaTalleres(talleresResponse.getTalleres());

            }else{
                Toast.makeText(getApplicationContext(),"Error en el formato ", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<TalleresResponse> call, Throwable t) {
            Toast.makeText(getApplicationContext(),"No hay conexión de Internet", Toast.LENGTH_SHORT).show();
        }
    }


}
