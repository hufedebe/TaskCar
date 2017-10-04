package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.graphics.Color;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.adapter.CarList_Adapter;
import com.taskcar.adapter.HorarioList_Adapter;
import com.taskcar.data.entity.CitaEntity;
import com.taskcar.data.entity.HorarioEntity;
import com.taskcar.db.helper.DatabaseHelper;
import com.taskcar.db.model.Car;
import com.taskcar.db.model.Cita;
import com.taskcar.model.CitaPost;
import com.taskcar.model.VehiculoPost;
import com.taskcar.presentation.Fragment.sTab1Fragment;
import com.taskcar.retrofit.AtencionVehicularAdapter;
import com.taskcar.retrofit.Response.CitaResponse;
import com.taskcar.retrofit.Response.VehiculoResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeleccionarFechaHora extends AppCompatActivity {

    private Button btn_generarCita;
    String init, finit, minit,mfin;
    String aperturamin, cierremin;
    String dia, mes, ano,usuario;
    String horarioCita;
    final DatabaseHelper db = new DatabaseHelper(this);
    String idTaller, nombreTaller, direccionTaller;
    CalendarView calendarView;
    String curDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_fecha_hora);

        Intent getResults = getIntent();
        String apertura = getResults.getStringExtra("apertura");
        String cierre = getResults.getStringExtra("cierre");
        String atenciones = getResults.getStringExtra("atenciones");
        idTaller= getResults.getStringExtra("idTaller");
        nombreTaller = getResults.getStringExtra("nombreTaller");
         direccionTaller = getResults.getStringExtra("direccionTaller");

        calendarView = (CalendarView) findViewById(R.id.calendar);

        //Validación del usuario
        if (RegisterMainActivity.dniUsuario!=null && !RegisterMainActivity.dniUsuario.isEmpty()){
            usuario = RegisterMainActivity.dniUsuario;
        }else if(RegisterActivity.dniUsuario!=null && !RegisterActivity.dniUsuario.isEmpty()){
            usuario = RegisterActivity.dniUsuario;
        }else{
            usuario = "12345678";
        }

        //String horario = getResults.getStringExtra("horario");

        Log.d("getTasksListHTTP", "Taller" + nombreTaller);
        init=apertura.substring(0,2);
        minit=apertura.substring(3,5);

        finit= cierre.substring(0,2);
        mfin=cierre.substring(3,5);
      //  mfin= cierre.substring(3,2);



        int vinit = Integer.parseInt(init);
        int vminit = Integer.parseInt(minit);

        int vfinit = Integer.parseInt(finit);
        int vmfin = Integer.parseInt(mfin);

        final ArrayList<HorarioEntity> horarioList = new ArrayList<HorarioEntity>();
        Integer minutos = vminit;

        for(Integer i=vinit;i<=vfinit;i++){


            do{
                Integer flag = minutos +15;
                if (minutos==0) {
                    if(i<10){
                        horarioList.add(new HorarioEntity(("0"+i.toString() + ":" + minutos.toString()+"0" + " - " + i.toString() + ":" + flag.toString()+ " ("+atenciones+ ")")));
                    }else {
                        horarioList.add(new HorarioEntity((i.toString() + ":" + minutos.toString() + "0" + " - " + i.toString() + ":" + flag.toString() + " (" + atenciones + ")")));
                    }
                }else{
                    if((i<10)&& (minutos<10)){
                        horarioList.add(new HorarioEntity(("0"+i.toString() + ":0" + minutos.toString() + " - " + i.toString() + ":" + flag.toString()+ " ("+atenciones+ ")")));

                    }else if(i<10){

                        horarioList.add(new HorarioEntity(("0"+i.toString() + ":" + minutos.toString() + " - " + i.toString() + ":" + flag.toString()+ " ("+atenciones+ ")")));

                    }else if(minutos<10){
                        horarioList.add(new HorarioEntity((i.toString() + ":0" + minutos.toString() + " - " + i.toString() + ":" + flag.toString()+ " ("+atenciones+ ")")));
                    }else{
                        horarioList.add(new HorarioEntity((i.toString() + ":" + minutos.toString() + " - " + i.toString() + ":" + flag.toString()+ " ("+atenciones+ ")")));
                    }

                }

                minutos = minutos +15;
            }while((minutos+15)<=45);

            Integer valor =i+1;
            Integer flag2 = 60-(minutos+15);
            //minutos = 60-minutos;

            if(flag2==0){
                horarioList.add(new HorarioEntity((i.toString()+":"+minutos.toString()+" - "+ valor.toString()+":"+ flag2.toString()+"0"+ " ("+atenciones+ ")" )));

            }else{
                horarioList.add(new HorarioEntity((i.toString()+":"+minutos.toString()+" - "+ valor.toString()+":"+ flag2.toString()+ " ("+atenciones+ ")" )));

            }

            minutos=flag2;
        }


        curDate = sdf.format(calendarView.getDate());
        //Toast.makeText(getApplicationContext(),horarios.get(2), Toast.LENGTH_LONG).show();
        final HorarioList_Adapter adapterHorario = new HorarioList_Adapter(this, horarioList);

        ListView listView = (ListView) findViewById(R.id.list);



        listView.setAdapter(adapterHorario);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String vmonth,vday,vyear;

                if(month<10){
                    vmonth="0"+String.valueOf(month);
                }else{
                    vmonth=String.valueOf(month);
                }
                if(dayOfMonth<10){
                    vday="0"+String.valueOf(dayOfMonth);
                }else{
                    vday=String.valueOf(dayOfMonth);
                }
                vyear= String.valueOf(year);
                curDate=vday+"/"+vmonth+"/"+vyear;
                Toast.makeText(getApplicationContext(), curDate, Toast.LENGTH_LONG).show();
            }
        });




        btn_generarCita = (Button) findViewById(R.id.btn_generarCita);

        btn_generarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer positiond=adapterHorario.selectedPosition;


                // curDate = sdf.format(calendarView.getDate());

                String data = horarioList.get(positiond).getHorario();
                String hora = data;
                data = data.substring(0,5);
                hora = hora.substring(0,2);
                if (Integer.parseInt(hora)<=12){
                    if(curDate !=null && !curDate.isEmpty()){

                        horarioCita = curDate + " " + data + " AM";
                    }else {
                        horarioCita = dia + "/" + mes + "/" + ano + " " + data + " AM";
                    }
                }else{
                    if(curDate !=null && !curDate.isEmpty()){

                        horarioCita = curDate + " " + data + " PM";
                    }else {
                        horarioCita = dia + "/" + mes + "/" + ano + " " + data + " PM";
                    }
                }
                //Toast.makeText(SeleccionarFechaHora.this,minit, Toast.LENGTH_SHORT).show();

                btn_generarCita.setBackgroundColor(Color.parseColor("#B71C1C"));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    finishAffinity();
                }

                CitaPost registroCita = new CitaPost(SeleccionarServicio.placa,horarioCita,"1",Observaciones.tipoServicio.toString(), sTab1Fragment.tipoHorario);
                //CitaPost registroCita = new CitaPost("KIM789");
                Call<CitaResponse> call = AtencionVehicularAdapter.getApiService().postRegistrarCita(registroCita);
                call.enqueue(new RegistrarCitaCallback());




                Intent intent = new Intent(SeleccionarFechaHora.this, CitasActivity.class);
                startActivity(intent);
            }
        });

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


    class RegistrarCitaCallback implements Callback<CitaResponse> {


        @Override
        public void onResponse(Call<CitaResponse> call, Response<CitaResponse> response) {
            if(response.isSuccessful()){
                CitaResponse citaResponse = response.body();
                if (citaResponse.getMensaje().getStatus()==200){
                    Log.d("getTasksListHTTP", "Taller" + nombreTaller);
                    db.addCita(new Cita(citaResponse.getMensaje().getIdEvento().toString(),usuario,idTaller,nombreTaller,direccionTaller,SeleccionarServicio.placa,horarioCita,"1","1"));
                    //db.addCar(new Car(placaVehiculo.getText().toString(), textMarca,textModelo));
                    Toast.makeText(getApplicationContext(),"Se registró correctamente la cita", Toast.LENGTH_LONG).show();

                    Intent registrarCita = new Intent(SeleccionarFechaHora.this, CitasActivity.class);
                    startActivity(registrarCita);
                }else{
                    Log.i("Retrofit", "post submitted to API." + response.body().toString());
                    Toast.makeText(getApplicationContext(),citaResponse.getMensaje().getStatus().toString(), Toast.LENGTH_SHORT).show();
                }


            }else{
                try {
                    //Toast.makeText(getApplicationContext(),response.errorBody().string(), Toast.LENGTH_SHORT).show();
                    Log.d("getTasksListHTTP", "Se añadio bien:"+response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

        @Override
        public void onFailure(Call<CitaResponse> call, Throwable t) {
            Toast.makeText(getApplicationContext(),"Error en la estructura", Toast.LENGTH_SHORT).show();
        }
    }





}
