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
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.R;

import static android.graphics.Color.RED;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class sTab1Fragment extends Fragment{
    private static final String TAG = "TAB1Fragment";

    private TextView txtDiurno;
    private TextView txtNocturno;
    private TextView txtExpress;
    public ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stab1_fragment,container,false);

        txtDiurno = (TextView) view.findViewById(R.id.txt_diurno);
        txtNocturno = (TextView) view.findViewById(R.id.txt_nocturno);
        txtExpress = (TextView) view.findViewById(R.id.txt_express);

        txtDiurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btnServicio2.setBackgroundColor(Color.parseColor("#E0E0E0"));
                //btnServicio3.setBackgroundColor(Color.parseColor("#E0E0E0"));
                //btnServicio1.setBackgroundColor(Color.parseColor("#B71C1C"));
                //Fragment fragment = new tasks();
                txtDiurno.setBackgroundColor(Color.parseColor("#B71C1C"));
                txtDiurno.setTextColor(Color.parseColor("#FFFFFFFF"));
                //----------------------------------------------
                txtNocturno.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtNocturno.setTextColor(Color.parseColor("#E0E0E0"));
                //----------------------------------------------
                txtExpress.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtExpress.setTextColor(Color.parseColor("#E0E0E0"));

                viewPager.setCurrentItem(1, true);
                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
            }
        });

        txtNocturno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btnServicio1.setBackgroundColor(Color.parseColor("#E0E0E0"));
               // btnServicio3.setBackgroundColor(Color.parseColor("#E0E0E0"));
                //btnServicio2.setBackgroundColor(Color.parseColor("#B71C1C"));
                txtNocturno.setBackgroundColor(Color.parseColor("#B71C1C"));
                txtNocturno.setTextColor(Color.parseColor("#FFFFFFFF"));
                //----------------------------------------------
                txtDiurno.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtDiurno.setTextColor(Color.parseColor("#E0E0E0"));
                //----------------------------------------------
                txtExpress.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtExpress.setTextColor(Color.parseColor("#E0E0E0"));


                viewPager.setCurrentItem(1, true);
                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
            }
        });

        txtExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // btnServicio1.setBackgroundColor(Color.parseColor("#E0E0E0"));
                //btnServicio2.setBackgroundColor(Color.parseColor("#E0E0E0"));
                //btnServicio3.setBackgroundColor(Color.parseColor("#B71C1C"));
                txtExpress.setBackgroundColor(Color.parseColor("#B71C1C"));
                txtExpress.setTextColor(Color.parseColor("#FFFFFFFF"));
                //----------------------------------------------
                txtDiurno.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtDiurno.setTextColor(Color.parseColor("#E0E0E0"));
                //----------------------------------------------
                txtNocturno.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                txtNocturno.setTextColor(Color.parseColor("#E0E0E0"));


                viewPager.setCurrentItem(1, true);
                //Toast.makeText(getActivity(),"Testing Button CLick 1", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }
}
