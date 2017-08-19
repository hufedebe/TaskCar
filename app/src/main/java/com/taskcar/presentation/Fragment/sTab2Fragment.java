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
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.presentation.Activity.Observaciones;
import com.taskcar.presentation.Activity.SeleccionarTaller;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class sTab2Fragment extends Fragment{

    private static final String TAG = "TAB2Fragment";

    private Button btnServicio1;
    private Button btnServicio2;
    private Button btnServicio3;
    private Button btnServicio4;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stab2_fragment,container,false);

        btnServicio1 = (Button) view.findViewById(R.id.btn_2servicio1);
        btnServicio2 = (Button) view.findViewById(R.id.btn_2servicio2);
        btnServicio3 = (Button) view.findViewById(R.id.btn_2servicio3);


        btnServicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServicio2.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio3.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio1.setBackgroundColor(Color.parseColor("#B71C1C"));
                //Fragment fragment = new tasks();

                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getActivity(), Observaciones.class);
                //intent1.putExtra("Mantenimiento",true);

                startActivity(intent1);
            }
        });

        btnServicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServicio1.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio3.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio2.setBackgroundColor(Color.parseColor("#B71C1C"));
                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getActivity(), Observaciones.class);

                //intent2.putExtra("Mantenimiento",false);
                startActivity(intent2);
            }
        });

        btnServicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServicio1.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio2.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio3.setBackgroundColor(Color.parseColor("#B71C1C"));
                //
                Intent intent3 = new Intent(getActivity(), Observaciones.class);
               // intent3.putExtra("Mantenimiento",true);
                startActivity(intent3);
            }
        });


        return view;
    }
}
