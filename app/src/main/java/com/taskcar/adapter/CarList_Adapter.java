package com.taskcar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.taskcar.R;
import com.taskcar.data.entity.CarEntity;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.db.model.Car;

import java.util.ArrayList;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class CarList_Adapter extends ArrayAdapter {

    private int amImageResourceId;
    public CarList_Adapter (Context context, ArrayList<Car> carEntity ){
        super(context, 0 , carEntity);
        //amImageResourceId =mImageResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_vehiculo, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Car currentCar = (Car) getItem(position);


        TextView placa = (TextView) listItemView.findViewById(R.id.placa_text_view);
        TextView marca = (TextView) listItemView.findViewById(R.id.marca_text_view);
        TextView modelo = (TextView) listItemView.findViewById(R.id.modelo_text_view);



        placa.setText(currentCar.getPlaca());
        marca.setText(currentCar.getMarca());
        modelo.setText(currentCar.getModelo());


        ImageView iconView = (ImageView)listItemView.findViewById(R.id.image);
       /* if (currentCar.hasImage()){
            iconView.setImageResource(currentCar.getmImageResourceId());
        }else{
            iconView.setVisibility(View.GONE);
        }
*/
        // View textContainer = listItemView.findViewById(R.id.text_container);
        //int color = ContextCompat.getColor(getContext(),amImageResourceId);
        //textContainer.setBackgroundColor(-1);
        //iconView.setImageResource(currentWord.getmImageResourceId());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }

}
