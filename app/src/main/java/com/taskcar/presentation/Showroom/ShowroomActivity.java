package com.taskcar.presentation.Showroom;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.taskcar.R;

public class ShowroomActivity extends AppCompatActivity {

    ViewPager viewPager;
    String marca;
    com.taskcar.presentation.Showroom.customSwipShowRoom customSwipShowRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_showroom);

        viewPager = (ViewPager) findViewById(R.id.viewPagerShowRoom);
        customSwipShowRoom = new customSwipShowRoom(this);

        viewPager.setAdapter(customSwipShowRoom);

    }
}
