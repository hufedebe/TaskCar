package com.taskcar.model;

/**
 * Created by Hudeya on 22/09/2017.
 */

public class MensajeCita {

    private Integer idEvento;
    private String text;
    private Integer status;

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
