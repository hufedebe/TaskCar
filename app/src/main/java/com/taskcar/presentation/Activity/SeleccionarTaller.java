package com.taskcar.presentation.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.taskcar.R;
import com.taskcar.presentation.Adapter.SelectionsPageAdapter;
import com.taskcar.presentation.Fragment.tTab1fragment;
import com.taskcar.presentation.Fragment.sTab2Fragment;
import com.taskcar.presentation.Fragment.tTab2fragment;

public class SeleccionarTaller extends AppCompatActivity {
    private static final String TAG = "SeleccionarActivity";

    private SelectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_taller);

        Log.d(TAG,"onCreate:Starting.");
        mSectionsPageAdapter = new SelectionsPageAdapter(getSupportFragmentManager());

        //Set up the ViewPaper with the sections adapter
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabsTaller);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SelectionsPageAdapter adapter = new SelectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new tTab1fragment(),"Lista de Talleres");
        adapter.addFragment(new tTab2fragment()," Mapa de Talleres");
        viewPager.setAdapter(adapter);
    }
}
