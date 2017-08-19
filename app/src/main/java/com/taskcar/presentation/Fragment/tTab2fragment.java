package com.taskcar.presentation.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.taskcar.R;
import com.taskcar.presentation.Activity.SeleccionarFechaHora;

/**
 * Created by Hudeya on 2/08/2017.
 */

public class tTab2fragment extends Fragment {

    private static final String TAG = "TAB1Fragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ttab2_fragment,container,false);


        return view;
    }



}
