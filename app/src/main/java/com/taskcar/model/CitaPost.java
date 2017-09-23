package com.taskcar.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hudeya on 22/09/2017.
 */

public class CitaPost {


    private String placa;
    private  String diaHoraEvento;
    private  String idTaller;
    private  String idServicio;
    private  String tipoHorario;

    public CitaPost(String placa){
        this.placa=placa;
    }
    public CitaPost(String placa, String diaHoraEvento, String idTaller, String idServicio, String tipoHorario){
        this.placa = placa;
        this.diaHoraEvento=diaHoraEvento;
        this.idTaller = idTaller;
        this.idServicio= idServicio;
        this.tipoHorario= tipoHorario;

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

    public String getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(String idTaller) {
        this.idTaller = idTaller;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipoHorario() {
        return tipoHorario;
    }

    public void setTipoHorario(String tipoHorario) {
        this.tipoHorario = tipoHorario;
    }
}
