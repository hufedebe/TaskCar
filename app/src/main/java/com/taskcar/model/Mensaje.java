package com.taskcar.model;

/**
 * Created by Hudeya on 12/09/2017.
 */

public class Mensaje {
    private String text;
    private Integer status;

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
