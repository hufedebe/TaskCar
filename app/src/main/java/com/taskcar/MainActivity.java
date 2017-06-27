package com.taskcar;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.taskcar.adapter.MenuList_Adapter;
import com.taskcar.data.MenuList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    ViewPager viewPager;
    customSwip  customSwip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        customSwip=new customSwip(this);
        viewPager.setAdapter(customSwip);

        final ArrayList<MenuList> menuLists = new ArrayList<MenuList>();
        menuLists.add(new MenuList("Iniciar Sesion",R.drawable.ic_iniciarsesion));
        menuLists.add(new MenuList("Gestionar Citas", R.drawable.ic_date));
        menuLists.add(new MenuList("Auxilio Mecánico", R.drawable.ic_auxilio));
        menuLists.add(new MenuList("Concesionarios", R.drawable.ic_concecionario));
        menuLists.add(new MenuList("Showroom", R.drawable.ic_showroom));


        MenuList_Adapter adapterMenu = new MenuList_Adapter(this, menuLists, R.color.colorPrimary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapterMenu);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuList menuList = menuLists.get(position);

                if (position ==1){
                       Intent registerActivity = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(registerActivity);
                }



            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);

        }
        return super.onOptionsItemSelected(item);
    }

    private void showFragment(String option){
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        //ft.replace(R.id.content, MainFragment.newInstance(option));
        //ft.commit();

    }
}
