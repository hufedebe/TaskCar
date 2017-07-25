package com.taskcar.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.taskcar.R;
import com.taskcar.data.MenuList;

import java.util.ArrayList;

/**
 * Created by Hudeya on 27/06/2017.
 */

public class MenuList_Adapter extends ArrayAdapter {
   private int amImageResourceId;
    public MenuList_Adapter (Context context, ArrayList<MenuList> menuList, int mImageResourceId ){
        super(context, 0 , menuList);
        amImageResourceId =mImageResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        MenuList currentMenu = (MenuList) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView menuTextView = (TextView) listItemView.findViewById(R.id.menu_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        menuTextView.setText(currentMenu.getmName());



        ImageView iconView = (ImageView)listItemView.findViewById(R.id.image);
        if (currentMenu.hasImage()){
            iconView.setImageResource(currentMenu.getmImageResourceId());
        }else{
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),amImageResourceId);
        //textContainer.setBackgroundColor(-1);
        //iconView.setImageResource(currentWord.getmImageResourceId());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }




}
