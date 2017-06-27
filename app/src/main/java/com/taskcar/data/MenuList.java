package com.taskcar.data;

/**
 * Created by Hudeya on 18/06/2017.
 */

public class MenuList {
    private String mName;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }


    public MenuList ( String mName){
        this.mName = mName;


    }

    public MenuList ( String mName, int mImageResourceId){
        this.mName = mName;
        this.mImageResourceId = mImageResourceId;

    }

    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
