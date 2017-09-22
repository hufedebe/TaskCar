package com.taskcar.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.taskcar.R;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.data.entity.HorarioEntity;
import com.taskcar.db.model.Car;
import com.taskcar.db.model.Horario;
import com.taskcar.presentation.Activity.SeleccionarFechaHora;
import com.taskcar.presentation.Activity.SeleccionarVehiculo;

import java.util.ArrayList;

/**
 * Created by Hudeya on 14/09/2017.
 */

public class HorarioList_Adapter extends ArrayAdapter{
    private Context context ;
    public int selectedPosition= 0;
    public Integer finalPosition=0;
    public RadioButton radioButton;


    public HorarioList_Adapter (Context context, ArrayList<HorarioEntity> horarioEntity ){
        super(context, 0 , horarioEntity);
        this.context = context;


    }
    public HorarioList_Adapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_horario, parent, false);
            RadioButton radioButton = (RadioButton)listItemView.findViewById(R.id.boton1);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final HorarioEntity currentHorario = (HorarioEntity) getItem(position);


        TextView horario = (TextView) listItemView.findViewById(R.id.txt_horario);
        horario.setText(currentHorario.getHorario());


        radioButton = (RadioButton)listItemView.findViewById(R.id.boton1);
        radioButton.setChecked(position==selectedPosition);
        radioButton.setTag(position);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = (Integer)view.getTag();
                finalPosition=position;
                notifyDataSetChanged();
            }
        });
               // int checkedID = rGroup.getCheckedRadioButtonId();





        return listItemView;

    }
}
