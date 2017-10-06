package com.taskcar.db.model;

/**
 * Created by Hudeya on 6/10/2017.
 */

public class Historia {
    private int id;
    private String dni;
    private String idEvento;
    private String idTaller;
    private String nombreTaller;
    private String direccionTaller;
    private String placa;
    private String diaHoraEvento;
    private String idServicio;
    private String tipoServicio;
    private String puntuacion;


    public Historia(){

    }

    public Historia(int id, String idEvento, String idTaller,String nombreTaller,String direccionTaller, String placa,
                String diaHoraEvento, String idServicio, String tipoServicio){

        this.setId(id);
        this.setIdEvento(idEvento);
        this.setIdTaller(idTaller);
        this.setNombreTaller(nombreTaller);
        this.setDireccionTaller(direccionTaller);
        this.setPlaca(placa);
        this.setDiaHoraEvento(diaHoraEvento);
        this.setIdServicio(idServicio);
        this.setTipoServicio(tipoServicio);
    }
    public Historia( String idEvento, String idTaller,String nombreTaller,String direccionTaller, String placa,
                 String diaHoraEvento, String idServicio, String tipoServicio,String puntuacion){


        this.setIdEvento(idEvento);
        this.setIdTaller(idTaller);
        this.setNombreTaller(nombreTaller);
        this.setDireccionTaller(direccionTaller);
        this.setPlaca(placa);
        this.setDiaHoraEvento(diaHoraEvento);
        this.setIdServicio(idServicio);
        this.setTipoServicio(tipoServicio);
        this.setPuntuacion(puntuacion);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(String idTaller) {
        this.idTaller = idTaller;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public String getDireccionTaller() {
        return direccionTaller;
    }

    public void setDireccionTaller(String direccionTaller) {
        this.direccionTaller = direccionTaller;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDiaHoraEvento() {
        return diaHoraEvento;
    }

    public void setDiaHoraEvento(String diaHoraEvento) {
        this.diaHoraEvento = diaHoraEvento;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
}
