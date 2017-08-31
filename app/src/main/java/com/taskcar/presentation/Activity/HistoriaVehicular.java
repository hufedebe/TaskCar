package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.taskcar.R;
import com.taskcar.adapter.CitaList_Adapter;
import com.taskcar.adapter.HistoriaVehicularList_Adapter;
import com.taskcar.data.entity.CitaEntity;

import java.util.ArrayList;

public class HistoriaVehicular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_vehicular);

        final ArrayList<CitaEntity> citaLists = new ArrayList<CitaEntity>();


        //Data dummy para visualizar una cita
        citaLists.add(new CitaEntity("Javier Prado","Av. Javier Prado 5635 - La Molina","03/02/07 - 10:00am",
                "YX1234"));

        HistoriaVehicularList_Adapter adapterCita = new HistoriaVehicularList_Adapter(this, citaLists);

        ListView listView = (ListView) findViewById(R.id.list_historiaVehicular);
        listView.setAdapter(adapterCita);


        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
