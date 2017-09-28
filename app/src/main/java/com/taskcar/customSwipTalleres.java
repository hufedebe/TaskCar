package com.taskcar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.taskcar.presentation.Fragment.EditorFragment;
import com.taskcar.presentation.Fragment.tTab2fragment;

/**
 * Created by Hudeya on 28/09/2017.
 */

public class customSwipTalleres extends FragmentPagerAdapter {
    Context ctxt=null;
    public customSwipTalleres(Context ctxt, FragmentManager mgr){
        super(mgr);
        this.ctxt= ctxt;
    }


    @Override
    public Fragment getItem(int position) {
        return(EditorFragment.newInstance(position));
    }


    @Override
    public int getCount() {
        return(10);
    }
    @Override
    public String getPageTitle(int position) {
        return(EditorFragment.getTitle(ctxt, position));
    }
}
