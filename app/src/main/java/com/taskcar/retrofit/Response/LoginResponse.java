package com.taskcar.retrofit.Response;

import com.taskcar.model.Mensaje;

/**
 * Created by Hudeya on 28/09/2017.
 */

public class LoginResponse {
    private Mensaje mensaje;

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }
}
