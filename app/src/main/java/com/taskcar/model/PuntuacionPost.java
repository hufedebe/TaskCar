package com.taskcar.model;

/**
 * Created by Hudeya on 7/10/2017.
 */

public class PuntuacionPost {
    private String idEvento;
    private String puntajeCliente;
    private String observacionCliente;

    public PuntuacionPost(String idEvento, String puntajeCliente, String observacionCliente){
        this.idEvento= idEvento;
        this.puntajeCliente= puntajeCliente;
        this.observacionCliente=observacionCliente;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getPuntajeCliente() {
        return puntajeCliente;
    }

    public void setPuntajeCliente(String puntajeCliente) {
        this.puntajeCliente = puntajeCliente;
    }

    public String getObservacionCliente() {
        return observacionCliente;
    }

    public void setObservacionCliente(String observacionCliente) {
        this.observacionCliente = observacionCliente;
    }
}
