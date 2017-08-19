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

import com.taskcar.presentation.Activity.MainActivity;
import com.taskcar.presentation.Activity.Observaciones;
import com.taskcar.presentation.Activity.RegisterActivity;
import com.taskcar.presentation.Activity.TestDrive;

/**
 * Created by Hudeya on 18/06/2017.
 */

public class customSwipShowRoom extends PagerAdapter {


    private int[] imageResources ={R.drawable.carshowroom1,R.drawable.carshowroom2,R.drawable.carshowroom3,
            R.drawable.carshowroom4};
    private String[] stringResources = {"Suzuki Alto 8000","Suzuki APV Furgon","Suzuki CIAZ","Suzuki Jimny"};
    private String[] stringResources2 ={"Desde $6,590/ S/549","Desde $6,590/ S/549","Desde $6,590/ S/549","Desde $6,590/ S/549"};
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
        TextView textView=(TextView) itemView.findViewById(R.id.text_showRoom);
        TextView textView1 = (TextView) itemView.findViewById(R.id.text2_showRoom);

        ImageView test_drive_image = (ImageView) itemView.findViewById(R.id.image_test_drive);
        TextView test_drive_text = (TextView) itemView.findViewById(R.id.test_drive_text);


        test_drive_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent solicitar = new Intent(v.getContext(), TestDrive.class);

                v.getContext().startActivity(solicitar);
            }
        });

        test_drive_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent solicitar1 = new Intent(v.getContext(), TestDrive.class);

                v.getContext().startActivity(solicitar1);
            }
        });


        imageView.setImageResource(imageResources[position]);
        textView.setText(stringResources[position]);
        textView1.setText(stringResources2[position]);
        container.addView(itemView);





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
