package com.taskcar.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.taskcar.R;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.db.model.Cita;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Hudeya on 30/07/2017.
 */

public class CitaList_Adapter extends ArrayAdapter {


    private int amImageResourceId;
    public CitaList_Adapter (Context context, ArrayList<Cita> citaEntity ){
        super(context, 0 , citaEntity);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_cita, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Cita currentCita = (Cita) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
      //  TextView menuTextView = (TextView) listItemView.findViewById(R.id.menu_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
       // menuTextView.setText(currentMenu.getmName());
        TextView nombreTaller = (TextView) listItemView.findViewById(R.id.taller_text_view);
        TextView direccionTaller = (TextView) listItemView.findViewById(R.id.direccion_text_view);
        TextView horario = (TextView) listItemView.findViewById(R.id.horario_text_view);
        TextView placa = (TextView) listItemView.findViewById(R.id.placa_text_view);
        TextView numeralCita = (TextView)listItemView.findViewById(R.id.numeral_cita);
        Log.d("getTasksListHTTP", "Taller" + currentCita.getNombreTaller());

        numeralCita.setText("Cita "+ (position+1)+" :");
        nombreTaller.setText(currentCita.getNombreTaller());

        direccionTaller.setText(currentCita.getDireccionTaller());
        horario.setText(currentCita.getDiaHoraEvento());
        placa.setText(currentCita.getPlaca());

     ///Reprograr y Contactar
        TextView contactar = (TextView) listItemView.findViewById(R.id.txt_contactar);

        contactar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posted_by = "994300027";

                String uri = "tel:" + posted_by.trim() ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                getContext().startActivity(intent);
            }
        });

       // View textContainer = listItemView.findViewById(R.id.text_container);
        //int color = ContextCompat.getColor(getContext(),amImageResourceId);
        //textContainer.setBackgroundColor(-1);
        //iconView.setImageResource(currentWord.getmImageResourceId());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }



}
