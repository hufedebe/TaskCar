package com.taskcar.db.model;

/**
 * Created by hfdeudor on 31/08/2017.
 */

public class Modelo {


    private int id;
    private String descripcion;


    public Modelo (){

    }

    public Modelo (int id, String descripcion){
        this.setId(id);
        this.setDescripcion(descripcion);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
