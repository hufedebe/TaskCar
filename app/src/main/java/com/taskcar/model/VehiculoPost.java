package com.taskcar.model;

/**
 * Created by Hudeya on 12/09/2017.
 */

public class VehiculoPost {
    private String placa;
    private String DNI;
    private String idMarca;
    private String idModelo;
    private String anio;

    public VehiculoPost(String placa, String dNI, String idMarca,String idModelo, String anio){
        this.placa= placa;
        this.DNI = dNI;
        this.idMarca = idMarca;
        this.idModelo= idModelo;
        this.anio=anio;

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        this.DNI = dNI;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public String getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

}
