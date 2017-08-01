package com.taskcar.data.entity;

/**
 * Created by Hudeya on 31/07/2017.
 */

public class CarEntity {

    private String modelo;
    private int cmodelo;

    private String marca;
    private int cmarca;

    private String placa;
    private String dni;
    private int anio;


    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCmodelo() {
        return cmodelo;
    }

    public void setCmodelo(int cmodelo) {
        this.cmodelo = cmodelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCmarca() {
        return cmarca;
    }

    public void setCmarca(int cmarca) {
        this.cmarca = cmarca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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

    public CarEntity(String placa, String marca, String modelo, int mImageResourceId){
        this.placa= placa;
        this.modelo = modelo;
        this.marca = marca;
        this.mImageResourceId = mImageResourceId;
    }

}
