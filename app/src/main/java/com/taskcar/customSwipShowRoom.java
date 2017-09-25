package com.taskcar;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.presentation.Activity.MainActivity;
import com.taskcar.presentation.Activity.Observaciones;
import com.taskcar.presentation.Activity.RegisterActivity;
import com.taskcar.presentation.Activity.TestDrive;

/**
 * Created by Hudeya on 18/06/2017.
 */

public class customSwipShowRoom extends PagerAdapter {


    private int[] imageResources ={R.drawable.changan_benni,R.drawable.changan_cs15,R.drawable.changan_grandvan};
    private String[] stringResources = {"Benni","CS15","Grand VAN Turismo"};
    private String[] stringResources2 ={"Desde $6,490/ S/21,222","Desde $11,290/ S/36,580","Desde $13,790/ S/44,680"};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public customSwipShowRoom(Context c) {
        ctx=c;
    }
    @Override
    public int getCount() {
        return imageResources.length;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView=layoutInflater.inflate(R.layout.activity_custom_swip_showroom,container,false);

        ImageView imageView=(ImageView) itemView.findViewById(R.id.swip_image_view);
        final TextView textView=(TextView) itemView.findViewById(R.id.text_showRoom);
        TextView textView1 = (TextView) itemView.findViewById(R.id.text2_showRoom);

        ImageView test_drive_image = (ImageView) itemView.findViewById(R.id.image_test_drive);
        TextView test_drive_text = (TextView) itemView.findViewById(R.id.test_drive_text);

        imageView.setImageResource(imageResources[position]);
        textView.setText(stringResources[position]);
        textView1.setText(stringResources2[position]);
        container.addView(itemView);


        test_drive_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"hufedebe@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Solicitud de Test Drive "+textView.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    ctx.startActivity(Intent.createChooser(i, "Enviando Email..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ctx.getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        test_drive_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"hufedebe@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Solicitud de Test Drive "+textView.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    ctx.startActivity(Intent.createChooser(i, "Enviando Email..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ctx.getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });






        return itemView;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return  (view==object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
