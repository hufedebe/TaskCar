package com.taskcar.model;

/**
 * Created by Hudeya on 3/10/2017.
 */

public class Servicio {
    private String nombreServicio;
    private Integer idServicio;

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio(String nombreServicio, Integer idServicio){
            this.nombreServicio= nombreServicio;
            this.idServicio= idServicio;
    }

}
