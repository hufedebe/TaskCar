package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;

import com.taskcar.R;
import com.taskcar.presentation.Adapter.SelectionsPageAdapter;
import com.taskcar.presentation.Fragment.sTab1Fragment;
import com.taskcar.presentation.Fragment.sTab2Fragment;

public class SeleccionarServicio extends AppCompatActivity {

    public static String placa;
    private static final String TAG = "SeleccionarActivity";

    private SelectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent getResults = getIntent();
        placa= getResults.getStringExtra("placa");

        setContentView(R.layout.activity_seleccionar_servicio);

        Log.d(TAG,"onCreate:Starting.");
        mSectionsPageAdapter = new SelectionsPageAdapter(getSupportFragmentManager());

        //Set up the ViewPaper with the sections adapter
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setupViewPager(ViewPager viewPager){
        SelectionsPageAdapter adapter = new SelectionsPageAdapter(getSupportFragmentManager());
        sTab1Fragment a = new sTab1Fragment();
        a.viewPager = mViewPager;
        adapter.addFragment(a,"Servicio");
        adapter.addFragment(new sTab2Fragment(),"Tipo de Servicio");
        viewPager.setAdapter(adapter);
    }
}
