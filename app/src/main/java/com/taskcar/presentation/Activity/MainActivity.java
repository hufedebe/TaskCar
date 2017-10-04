package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
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

import com.taskcar.R;
import com.taskcar.presentation.Showroom.ShowroomActivity;
import com.taskcar.adapter.MenuList_Adapter;
import com.taskcar.customSwip;
import com.taskcar.data.entity.MenuList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    public static boolean ingreso;
    ViewPager viewPager;
    com.taskcar.customSwip customSwip;
    final ArrayList<MenuList> menuLists = new ArrayList<MenuList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //-----Navigation View ---------//
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_inicio:

                        break;
                    case R.id.menu_citas:
                        Intent citaActivity = new Intent(MainActivity.this, CitasActivity.class);
                        startActivity(citaActivity);
                        break;
                    case R.id.menu_talleres:
                        Intent tallerActivity = new Intent(MainActivity.this, SeleccionarTaller.class);
                        startActivity(tallerActivity);
                        break;
                    case R.id.menu_showRoom:
                        Intent showRoomActivity = new Intent(MainActivity.this, ShowroomActivity.class);
                        startActivity(showRoomActivity);
                        break;
                    case R.id.menu_salir:
                       finish();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });



        viewPager=(ViewPager)findViewById(R.id.viewPager);
        customSwip=new customSwip(this);
        viewPager.setAdapter(customSwip);

        if (ingreso){
            menuLists.clear();

            menuLists.add(new MenuList("Gestionar Citas", R.drawable.ic_date));
            menuLists.add (new MenuList("Historia Vehicular", R.drawable.ic_historia_vehicular));
            menuLists.add(new MenuList("Talleres", R.drawable.ic_concecionario));
            menuLists.add(new MenuList("Showroom", R.drawable.ic_showroom));
            menuLists.add(new MenuList("Salir", R.drawable.ic_close));

        }else{
            menuLists.clear();

            menuLists.add(new MenuList("Iniciar Sesión", R.drawable.ic_iniciarsesion));
            menuLists.add(new MenuList("Talleres", R.drawable.ic_concecionario));
            menuLists.add(new MenuList("Showroom", R.drawable.ic_showroom));
            menuLists.add(new MenuList("Salir", R.drawable.ic_close));

        }

        //menuLists.add(new MenuList("Iniciar Sesión", R.drawable.ic_iniciarsesion));
        //menuLists.add(new MenuList("Gestionar Citas", R.drawable.ic_date));
        //menuLists.add (new MenuList("Historia Vehicular", R.drawable.ic_historia_vehicular));
        //menuLists.add(new MenuList("Talleres", R.drawable.ic_concecionario));
        //menuLists.add(new MenuList("Showroom", R.drawable.ic_showroom));
        //menuLists.add(new MenuList("Salir", R.drawable.ic_close));

        MenuList_Adapter adapterMenu = new MenuList_Adapter(this, menuLists, R.color.colorPrimary);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapterMenu);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MenuList menuList = menuLists.get(position);

                if(ingreso){
                    switch(position){

                        case 0: Intent citaActivity = new Intent(MainActivity.this, CitasActivity.class);
                            startActivity(citaActivity);
                            break;
                        case 1: Intent historiaActivity = new Intent(MainActivity.this, HistoriaVehicular.class);
                            startActivity(historiaActivity);
                            break;
                        case 2: Intent tallerActivity = new Intent(MainActivity.this, SeleccionarTaller.class);
                            startActivity(tallerActivity);
                            break;
                        case 3: Intent showRoomActivity = new Intent(MainActivity.this, ShowRoomMain.class);
                            startActivity(showRoomActivity);
                            break;
                        case 4:
                            ingreso= false;
                            finish();
                            startActivity(getIntent());
                            break;
                    }
                }else{

                    switch(position){
                        case 0: Intent registerActivity = new Intent(MainActivity.this, RegisterActivity.class);
                            startActivity(registerActivity);
                            break;
                        case 1: Intent tallerActivity = new Intent(MainActivity.this, SeleccionarTaller.class);
                            startActivity(tallerActivity);
                            break;
                        case 2: Intent showRoomActivity = new Intent(MainActivity.this, ShowRoomMain.class);
                            startActivity(showRoomActivity);
                            break;
                        case 3:
                            finish();
                            break;
                    }


                }
                /*
                switch(position){
                    case 0: Intent registerActivity = new Intent(MainActivity.this, RegisterActivity.class);
                            startActivity(registerActivity);
                            break;
                    case 1: Intent citaActivity = new Intent(MainActivity.this, CitasActivity.class);
                            startActivity(citaActivity);
                        break;
                    case 2: Intent historiaActivity = new Intent(MainActivity.this, HistoriaVehicular.class);
                            startActivity(historiaActivity);
                        break;
                    case 3: Intent tallerActivity = new Intent(MainActivity.this, SeleccionarTaller.class);
                             startActivity(tallerActivity);
                        break;
                    case 4: Intent showRoomActivity = new Intent(MainActivity.this, ShowRoomMain.class);
                            startActivity(showRoomActivity);
                        break;
                    case 5:
                        finish();
                        break;
                }
                */
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
