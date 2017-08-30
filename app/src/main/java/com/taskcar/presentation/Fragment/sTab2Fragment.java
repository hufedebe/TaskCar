package com.taskcar.presentation.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.presentation.Activity.Observaciones;
import com.taskcar.presentation.Activity.SeleccionarTaller;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class sTab2Fragment extends Fragment{

    private static final String TAG = "TAB2Fragment";



    private TextView txtReparacion;
    private TextView txtMantenimiento;
    private TextView txtReparacionMantenimiento;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stab2_fragment,container,false);

        txtMantenimiento= (TextView) view.findViewById(R.id.txt_mantenimiento);
        txtReparacion = (TextView) view.findViewById(R.id.txt_reparacion);
        txtReparacionMantenimiento= (TextView) view.findViewById(R.id.txt_mantenimiento_reparacion);


        txtMantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtMantenimiento.setBackgroundColor(Color.parseColor("#B71C1C"));
                txtMantenimiento.setTextColor(Color.parseColor("#FFFFFFFF"));
                //----------------------------------------------
                txtReparacion.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtReparacion.setTextColor(Color.parseColor("#E0E0E0"));
                //----------------------------------------------
                txtReparacionMantenimiento.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtReparacionMantenimiento.setTextColor(Color.parseColor("#E0E0E0"));


                Intent mantenimiento = new Intent(getActivity(), Observaciones.class);
                mantenimiento.putExtra("key1","1");
                mantenimiento.putExtra("key2","0");
                mantenimiento.putExtra("key3","0");
                getActivity().startActivity(mantenimiento);
            }
        });

        txtReparacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtReparacion.setBackgroundColor(Color.parseColor("#B71C1C"));
                txtReparacion.setTextColor(Color.parseColor("#FFFFFFFF"));
                //----------------------------------------------
                txtMantenimiento.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtMantenimiento.setTextColor(Color.parseColor("#E0E0E0"));
                //----------------------------------------------
                txtReparacionMantenimiento.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtReparacionMantenimiento.setTextColor(Color.parseColor("#E0E0E0"));

                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
                Intent reparacion = new Intent(getActivity(), Observaciones.class);
                reparacion.putExtra("key2","1");
                reparacion.putExtra("key1","0");
                reparacion.putExtra("key3","0");
                getActivity().startActivity(reparacion);


            }
        });

        txtReparacionMantenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtReparacionMantenimiento.setBackgroundColor(Color.parseColor("#B71C1C"));
                txtReparacionMantenimiento.setTextColor(Color.parseColor("#FFFFFFFF"));
                //----------------------------------------------
                txtMantenimiento.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtMantenimiento.setTextColor(Color.parseColor("#E0E0E0"));
                //----------------------------------------------
                txtReparacion.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtReparacion.setTextColor(Color.parseColor("#E0E0E0"));

                //
                Intent mantenimiento2 = new Intent(getActivity(), Observaciones.class);
                mantenimiento2.putExtra("key3","1");
                mantenimiento2.putExtra("key1","0");
                mantenimiento2.putExtra("key2","0");
                getActivity().startActivity(mantenimiento2);
            }
        });


        return view;
    }
}
