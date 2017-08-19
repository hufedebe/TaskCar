package com.taskcar.presentation.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.taskcar.R;

import static android.graphics.Color.RED;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class sTab1Fragment extends Fragment{
    private static final String TAG = "TAB1Fragment";

    private Button btnServicio1;
    private Button btnServicio2;
    private Button btnServicio3;
    private Button btnServicio4;
    public ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stab1_fragment,container,false);

        btnServicio1 = (Button) view.findViewById(R.id.btn_servicio1);
        btnServicio2 = (Button) view.findViewById(R.id.btn_servicio2);
        btnServicio3 = (Button) view.findViewById(R.id.btn_servicio3);

        btnServicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServicio2.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio3.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio1.setBackgroundColor(Color.parseColor("#B71C1C"));
                //Fragment fragment = new tasks();
                viewPager.setCurrentItem(1, true);
                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
            }
        });

        btnServicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServicio1.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio3.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio2.setBackgroundColor(Color.parseColor("#B71C1C"));
                viewPager.setCurrentItem(1, true);
                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
            }
        });

        btnServicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServicio1.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio2.setBackgroundColor(Color.parseColor("#E0E0E0"));
                btnServicio3.setBackgroundColor(Color.parseColor("#B71C1C"));
                viewPager.setCurrentItem(1, true);
                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }
}
