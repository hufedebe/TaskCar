package com.taskcar.presentation.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.taskcar.R;
import com.taskcar.ShowroomActivity;

public class ShowRoomMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_room_main);

        ImageView btn_changan = (ImageView) findViewById(R.id.image_changan);
        ImageView btn_citroen = (ImageView) findViewById(R.id.image_citroen);
        ImageView btn_ds = (ImageView) findViewById(R.id.image_ds);
        ImageView btn_fonton = (ImageView) findViewById(R.id.image_fonton);
        ImageView btn_great = (ImageView) findViewById(R.id.image_great);
        ImageView btn_hawall = (ImageView) findViewById(R.id.image_hawall);
        ImageView btn_jac = (ImageView) findViewById(R.id.image_jac);
        ImageView btn_mazda = (ImageView) findViewById(R.id.image_mazda);
        ImageView btn_suzuki = (ImageView) findViewById(R.id.image_suzuki);
        ImageView btn_todos = (ImageView) findViewById(R.id.image_todos);


        btn_changan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });
        btn_citroen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });
        btn_ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });
        btn_fonton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });
        btn_great.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });
        btn_hawall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });
        btn_jac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });
        btn_mazda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });
        btn_suzuki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });

        btn_todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showRoomActivity = new Intent(ShowRoomMain.this, ShowroomActivity.class);
                startActivity(showRoomActivity);
            }
        });



    }
}
