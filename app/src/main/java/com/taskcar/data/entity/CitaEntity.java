package com.taskcar.data.entity;

/**
 * Created by Hudeya on 30/07/2017.
 */

public class CitaEntity {
    private String idCita;
    private String nombreTaller;
    private String direccion;
    private String horario;
    private String placa;

    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }


    //constructor
    public CitaEntity ( String cTaller, String cDireccion, String cHorario, String cPlaca){
        this.nombreTaller = cTaller;
        this.direccion= cDireccion;
        this.horario= cHorario;
        this.placa= cPlaca;


    }



}
