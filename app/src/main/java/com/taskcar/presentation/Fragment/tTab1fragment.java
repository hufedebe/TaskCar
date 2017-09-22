package com.taskcar.presentation.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    final ArrayList<tallerEntity> tallerLists = new ArrayList<tallerEntity>();
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
        for (Taller r: talleres){
            tallerLists.add(new tallerEntity(r.getAperturaNocturno(),r.getLatitud(),r.getCierreNocturno(),
                                            r.getTelefonoTaller(),r.getAperturaExpress(),r.getAtencionesExpress(),
                                            r.getAperturaDiurno(),r.getAtencionesNocturno(),r.getCierreExpress(),
                                            r.getNombreTaller(),r.getLongitud(),r.getAtencionesDiurno(), r.getDireccionTaller(),
                                            r.getIdTaller(),r.getCierreDiurno()));

        }
        final TallerList_Adapter adapterTaller = new TallerList_Adapter(getView().getContext(), tallerLists);

        listView = (ListView) getView().findViewById(R.id.list);
        listView.setAdapter(adapterTaller);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
               // Toast.makeText(getApplicationContext(),"Si selecciona ", Toast.LENGTH_SHORT).show();
                final Taller currentTaller = (Taller) adapterTaller.getItem(position);
                Intent taller = new Intent(getActivity(), SeleccionarFechaHora.class);
                taller.putExtra("apertura",currentTaller.getAperturaDiurno());
                getActivity().startActivity(taller);
            }
        });

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
