package com.taskcar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.db.model.Historia;
import com.taskcar.model.LoginPost;
import com.taskcar.model.PuntuacionPost;
import com.taskcar.presentation.Activity.MainActivity;
import com.taskcar.presentation.Activity.RegisterActivity;
import com.taskcar.retrofit.AtencionVehicularAdapter;
import com.taskcar.retrofit.Response.LoginResponse;
import com.taskcar.retrofit.Response.PuntuacionResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.password;
import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Hudeya on 30/07/2017.
 */

public class HistoriaVehicularList_Adapter extends ArrayAdapter {

    public RatingBar ratingBar;
    private int amImageResourceId;
    public HistoriaVehicularList_Adapter(Context context, ArrayList<Historia> historia ){
        super(context, 0 , historia);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_historiavehicular, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Historia currentHistoria = (Historia) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
      //  TextView menuTextView = (TextView) listItemView.findViewById(R.id.menu_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
       // menuTextView.setText(currentMenu.getmName());
        TextView nombreTaller = (TextView) listItemView.findViewById(R.id.taller_text_view);
        TextView direccionTaller = (TextView) listItemView.findViewById(R.id.direccion_text_view);
        TextView horario = (TextView) listItemView.findViewById(R.id.horario_text_view);
        TextView placa = (TextView) listItemView.findViewById(R.id.placa_text_view);
        TextView fechaCita = (TextView) listItemView.findViewById(R.id.fecha_cita);

        ratingBar = (RatingBar) listItemView.findViewById(R.id.rating);
        nombreTaller.setText(currentHistoria.getNombreTaller());
        direccionTaller.setText(currentHistoria.getDireccionTaller());
        horario.setText(currentHistoria.getDiaHoraEvento());
        placa.setText(currentHistoria.getPlaca());
        fechaCita.setText(currentHistoria.getDiaHoraEvento().substring(0,8));

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                PuntuacionPost puntuacionPost = new PuntuacionPost(currentHistoria.getIdEvento().toString(), Integer.toString((int)ratingBar.getRating()), "Todo bien");

                Call<PuntuacionResponse> call = AtencionVehicularAdapter.getApiService().postSetearPuntuacion(puntuacionPost);
                call.enqueue(new PuntuacionCallback());
            }
        });
        /*
        ratingBar.setOnTouchListener(new View.OnTouchListener() {
                 @Override
                 public boolean onTouch(View v, MotionEvent event) {
                     if (event.getAction() == MotionEvent.ACTION_UP) {
                         PuntuacionPost puntuacionPost = new PuntuacionPost(currentHistoria.getIdEvento().toString(), Integer.toString((int)ratingBar.getRating()), "Todo bien");

                         Call<PuntuacionResponse> call = AtencionVehicularAdapter.getApiService().postSetearPuntuacion(puntuacionPost);
                         call.enqueue(new PuntuacionCallback());
                     }
                     return true;
                 }

                                     }); */

       // View textContainer = listItemView.findViewById(R.id.text_container);
        //int color = ContextCompat.getColor(getContext(),amImageResourceId);
        //textContainer.setBackgroundColor(-1);
        //iconView.setImageResource(currentWord.getmImageResourceId());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }

     class PuntuacionCallback implements Callback<PuntuacionResponse>{

         @Override
         public void onResponse(Call<PuntuacionResponse> call, Response<PuntuacionResponse> response) {
             if(response.isSuccessful()){
                 PuntuacionResponse puntuacionResponse = response.body();
                 if (puntuacionResponse.getMensaje().getStatus()==200){

                     Toast.makeText(getApplicationContext(),"Puntuación Enviada Correctamente", Toast.LENGTH_LONG).show();


                 }else{

                     Toast.makeText(getApplicationContext(),"Problemas de Conexión", Toast.LENGTH_SHORT).show();
                 }


             }else{

                 Toast.makeText(getApplicationContext(),"Problemas Conexion", Toast.LENGTH_SHORT).show();


             }
         }

         @Override
         public void onFailure(Call<PuntuacionResponse> call, Throwable t) {

         }
     }


}
