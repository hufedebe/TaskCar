package com.taskcar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.data.entity.tallerEntity;
import com.taskcar.presentation.Activity.Observaciones;
import com.taskcar.presentation.Activity.SeleccionarFechaHora;
import com.taskcar.presentation.Activity.SeleccionarVehiculo;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Hudeya on 12/09/2017.
 */

public class TallerList_Adapter extends ArrayAdapter {
    private Context context ;
    public TallerList_Adapter(Context context, ArrayList<tallerEntity> tallerEntity) {
        super(context, 0, tallerEntity);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_taller, parent, false);
        }
        tallerEntity currentTaller = (tallerEntity) getItem(position);

        TextView nombreTaller = (TextView) listItemView.findViewById(R.id.txt_nombreTaller);
        TextView direccionTaller = (TextView) listItemView.findViewById(R.id.txt_direccion);
        TextView tipoServicio = (TextView) listItemView.findViewById(R.id.txt_tipoServicio);

        nombreTaller.setText(currentTaller.getNombreTaller());
        direccionTaller.setText(currentTaller.getDireccionTaller());

        LinearLayout taller = (LinearLayout) listItemView.findViewById(R.id.taller_1);
        taller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Si selecciona ", Toast.LENGTH_SHORT).show();
                Intent reparacion = new Intent(getApplicationContext(), SeleccionarFechaHora.class);

                getApplicationContext().startActivity(reparacion);
                //Intent intent=new Intent(context, SeleccionarFechaHora.class);
                //context.startActivity(intent);
            }
        });

        return listItemView;
    }
}
