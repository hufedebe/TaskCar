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
import android.widget.LinearLayout;

import com.taskcar.R;
import com.taskcar.presentation.Activity.SeleccionarFechaHora;
import com.taskcar.presentation.Activity.SeleccionarTaller;

/**
 * Created by Hudeya on 2/08/2017.
 */

public class tTab1fragment extends Fragment {

    private static final String TAG = "TAB1Fragment";
    private LinearLayout taller1;
    private LinearLayout taller2;
    private LinearLayout taller3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ttab1_fragment,container,false);

        taller1 = (LinearLayout) view.findViewById(R.id.taller_1);

        taller2 = (LinearLayout) view.findViewById(R.id.taller_2);

        taller3 = (LinearLayout) view.findViewById(R.id.taller_3);

        taller1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeleccionarFechaHora.class);
                startActivity(intent);
            }
        });
        taller2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeleccionarFechaHora.class);
                startActivity(intent);
            }
        });
        taller3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeleccionarFechaHora.class);
                startActivity(intent);
            }
        });
        return view;
    }



}
