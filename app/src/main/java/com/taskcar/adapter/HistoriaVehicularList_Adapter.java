package com.taskcar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.taskcar.R;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.db.model.Historia;

import java.util.ArrayList;

/**
 * Created by Hudeya on 30/07/2017.
 */

public class HistoriaVehicularList_Adapter extends ArrayAdapter {


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
        Historia currentHistoria = (Historia) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
      //  TextView menuTextView = (TextView) listItemView.findViewById(R.id.menu_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
       // menuTextView.setText(currentMenu.getmName());
        TextView nombreTaller = (TextView) listItemView.findViewById(R.id.taller_text_view);
        TextView direccionTaller = (TextView) listItemView.findViewById(R.id.direccion_text_view);
        TextView horario = (TextView) listItemView.findViewById(R.id.horario_text_view);
        TextView placa = (TextView) listItemView.findViewById(R.id.placa_text_view);


        nombreTaller.setText(currentHistoria.getNombreTaller());
        direccionTaller.setText(currentHistoria.getDireccionTaller());
        horario.setText(currentHistoria.getDiaHoraEvento());
        placa.setText(currentHistoria.getPlaca());



       // View textContainer = listItemView.findViewById(R.id.text_container);
        //int color = ContextCompat.getColor(getContext(),amImageResourceId);
        //textContainer.setBackgroundColor(-1);
        //iconView.setImageResource(currentWord.getmImageResourceId());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }



}
