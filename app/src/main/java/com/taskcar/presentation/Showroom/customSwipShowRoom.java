package com.taskcar.presentation.Showroom;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.taskcar.R;
import com.taskcar.presentation.Activity.MainActivity;
import com.taskcar.presentation.Activity.Observaciones;
import com.taskcar.presentation.Activity.RegisterActivity;
import com.taskcar.presentation.Activity.ShowRoomMain;
import com.taskcar.presentation.Activity.TestDrive;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Hudeya on 18/06/2017.
 */

public class customSwipShowRoom extends PagerAdapter {


    private int[] imageResources={R.drawable.changan_benni,R.drawable.changan_cs15,R.drawable.changan_grandvan};
    private String[] stringResources={"Benni","CS15","Grand VAN Turismo"} ;
    private String[] stringResources2= {"Desde $6,490/ S/21,222","Desde $11,290/ S/36,580","Desde $13,790/ S/44,680"};
    private Context ctx;
    private LayoutInflater layoutInflater;
    private String marca;

    public customSwipShowRoom(Context c) {
        ctx=c;
    }
    @Override
    public int getCount() {
        marca = ShowRoomMain.modelo.trim();
        //marca = "changan";
        if(marca.equals("changan")){
            imageResources= new int[]{R.drawable.changan_benni,R.drawable.changan_cs15,R.drawable.changan_grandvan};
            stringResources= new String[]{"Benni","CS15","Grand VAN Turismo"};
            stringResources2 = new String[]{"Desde $6,490/ S/21,222","Desde $11,290/ S/36,580","Desde $13,790/ S/44,680"};

        }else if(marca.equals("citroen")){
            imageResources= new int[]{R.drawable.citroencelysse,R.drawable.citroen_c3,R.drawable.citroen_berlingo,R.drawable.citroen_c4};
            stringResources= new String[]{"C-Elysee", "New C3", "Berlingo", "New C4"};
            stringResources2 = new String[]{"Desde $12,693/ S/41,116","Desde $17,990/ S/58,288","Desde $15,990/ S/51,808","Desde $16,990/ S/55,048"};
        }else if(marca.equals("ds")){
            imageResources= new int[]{R.drawable.ds_3,R.drawable.ds_4,R.drawable.ds_5};
            stringResources= new String[]{"DS 3", "DS 4", "DS 5"};
            stringResources2 = new String[]{"Desde $23,990/ S/77,728","Desde $27,490/ S/89,068","Desde $42,990/ S/139,2888"};
        }else if(marca.equals("foton")){
            imageResources= new int[]{R.drawable.foton_sauvana,R.drawable.foton_k1};
            stringResources= new String[]{"Sauvana", "K1"};
            stringResources2 = new String[]{"Desde $20,490/ S/66,388","Desde $26,290/ S/85,180"};
        }else if(marca.equals("Great Wall")){
            imageResources= new int[]{R.drawable.greatwall_m4,R.drawable.greatwall_m3,R.drawable.greatwall_wingle};
            stringResources= new String[]{"M4", "M3", "Wingle 5"};
            stringResources2 = new String[]{"Desde $10,290/ S/33,340","Desde $13,990/ S/45,328","Desde $15,990/ S/51,808"};
        }else if(marca.equals("Haval")){
            //imageResources= new int[]{R.drawable.haval_h1,R.drawable.haval_h2,R.drawable.haval_h6};
            stringResources= new String[]{"H1", "H2","H6"};
            stringResources2 = new String[]{"Desde $12,690/ S/41,116","Desde $16,490/ S/53,428","Desde $17,490/ S/56,668"};
        }else if(marca.equals("Jac")){
            //imageResources= new int[]{R.drawable.jac_j4,R.drawable.jac_nueva_refine,R.drawable.jac_s2};
            stringResources= new String[]{"J4", "Nueva Refine", "S2"};
            stringResources2 = new String[]{"Desde $9,790/ S/31,720","Desde $17,290/ S/56,020","Desde $10,990/ S/35,608"};
        }


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

     //   Toast.makeText(getApplicationContext(),ShowRoomMain.modelo, Toast.LENGTH_LONG).show();


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
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL  , new String[]{"hufedebe@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Solicitud de Test Drive "+textView.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    ctx.startActivity(Intent.createChooser(email, "Enviando Email..."));
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
