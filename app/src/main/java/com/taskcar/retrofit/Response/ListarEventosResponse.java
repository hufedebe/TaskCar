package com.taskcar.retrofit.Response;

import com.taskcar.model.Evento;

import java.util.List;

/**
 * Created by Hudeya on 6/10/2017.
 */

public class ListarEventosResponse {
    private List<Evento> eventos = null;

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

}
