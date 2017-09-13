package com.taskcar.retrofit.Response;

import com.taskcar.model.Taller;

import java.util.ArrayList;

/**
 * Created by Hudeya on 12/09/2017.
 */

public class TalleresResponse {
    private ArrayList<Taller> talleres;


    public ArrayList<Taller> getTalleres() {
        return talleres;
    }

    public void setTalleres(ArrayList<Taller> talleres) {
        this.talleres = talleres;
    }
}
