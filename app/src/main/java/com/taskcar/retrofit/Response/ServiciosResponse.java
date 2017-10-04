package com.taskcar.retrofit.Response;

import com.taskcar.model.Servicio;

import java.util.List;

/**
 * Created by Hudeya on 3/10/2017.
 */

public class ServiciosResponse {

    private List<Servicio> servicios = null;

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }


}
