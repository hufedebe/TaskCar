package com.taskcar.db.model;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class Cita {

    private int id;
    private String idEvento;
    private String idTaller;
    private String nombreTaller;
    private String direccionTaller;
    private String placa;
    private String diaHoraEvento;
    private String idServicio;
    private String tipoServicio;


    public Cita(){

    }

    public Cita(int id, String idEvento, String idTaller,String nombreTaller,String direccionTaller, String placa,
                String diaHoraEvento, String idServicio, String tipoServicio){

        this.id= id;
        this.idEvento = idEvento;
        this.idTaller = idTaller;
        this.setNombreTaller(nombreTaller);
        this.direccionTaller = direccionTaller;
        this.placa = placa;
        this.diaHoraEvento = diaHoraEvento;
        this.idServicio = idServicio;
        this.tipoServicio = tipoServicio;
    }
    public Cita( String idEvento, String idTaller,String nombreTaller,String direccionTaller, String placa,
                String diaHoraEvento, String idServicio, String tipoServicio){


        this.idEvento = idEvento;
        this.idTaller = idTaller;
        this.setNombreTaller(nombreTaller);
        this.direccionTaller = direccionTaller;
        this.placa = placa;
        this.diaHoraEvento = diaHoraEvento;
        this.idServicio = idServicio;
        this.tipoServicio = tipoServicio;
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

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }
}
