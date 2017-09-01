package com.taskcar.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.taskcar.R;
import com.taskcar.data.entity.CarEntity;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.db.helper.DatabaseHelper;
import com.taskcar.db.model.Car;
import com.taskcar.presentation.Activity.SeleccionarVehiculo;

import java.util.ArrayList;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class CarList_Adapter extends ArrayAdapter {
    private DatabaseHelper dbHelper;
    private Context context ;
   // final DatabaseHelper db = new DatabaseHelper(this);
    private int amImageResourceId;
    public CarList_Adapter (Context context, ArrayList<Car> carEntity ){
        super(context, 0 , carEntity);
        //amImageResourceId =mImageResourceId;
        this.dbHelper = new DatabaseHelper(context.getApplicationContext());
        this.context = context;
        //this.values = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_vehiculo, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Car currentCar = (Car) getItem(position);


        TextView placa = (TextView) listItemView.findViewById(R.id.placa_text_view);
        TextView marca = (TextView) listItemView.findViewById(R.id.marca_text_view);
        TextView modelo = (TextView) listItemView.findViewById(R.id.modelo_text_view);



        placa.setText(currentCar.getPlaca());
        marca.setText(currentCar.getMarca());
        modelo.setText(currentCar.getModelo());


        ImageView iconView = (ImageView)listItemView.findViewById(R.id.image);

        //Cogiendo botoenes:
        final ImageButton modificarBtn = (ImageButton)listItemView.findViewById(R.id.modificar);
        final ImageButton eliminarBtn = (ImageButton)listItemView.findViewById(R.id.eliminar);

        modificarBtn.setTag(position);
        modificarBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        eliminarBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                dbHelper.deleteCar(currentCar);
                Intent intent=new Intent(context, SeleccionarVehiculo.class);
                context.startActivity(intent);

            }
        });

        return listItemView;

    }

}
