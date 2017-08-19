package com.taskcar;

import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ShowroomActivity extends AppCompatActivity {

    ViewPager viewPager;
    com.taskcar.customSwipShowRoom customSwipShowRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showroom);

        viewPager = (ViewPager) findViewById(R.id.viewPagerShowRoom);
        customSwipShowRoom = new customSwipShowRoom(this);
        viewPager.setAdapter(customSwipShowRoom);

    }
}
