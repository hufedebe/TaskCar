package com.taskcar.db.model;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class Cita {

    private int id;
    private String placa;
    private String diaHora;
    private String taller;

    public Cita(){

    }

    public Cita(int id, String placa, String diaHora, String taller){
        this.id = id;
        this.placa=placa;
        this.diaHora=diaHora;
        this.taller=taller;
    }

    public Cita (String placa, String diaHora, String taller){
        this.placa = placa;
        this.diaHora= diaHora;
        this.taller= taller;
    }


}
