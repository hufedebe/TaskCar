package com.taskcar.data.entity;

/**
 * Created by Hudeya on 12/09/2017.
 */

public class tallerEntity {
    private String aperturaNocturno;
    private Float latitud;
    private String cierreNocturno;
    private Integer telefonoTaller;
    private String aperturaExpress;
    private Integer atencionesExpress;
    private String aperturaDiurno;
    private Integer atencionesNocturno;
    private String cierreExpress;
    private String nombreTaller;
    private Float longitud;
    private Integer atencionesDiurno;
    private String direccionTaller;
    private Integer idTaller;
    private String cierreDiurno;

    public tallerEntity(){

    }

    public tallerEntity(String nombreTaller, String direccionTaller){
        this.nombreTaller = nombreTaller;
        this.direccionTaller=direccionTaller;
    }

    public String getAperturaNocturno() {
        return aperturaNocturno;
    }

    public void setAperturaNocturno(String aperturaNocturno) {
        this.aperturaNocturno = aperturaNocturno;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public String getCierreNocturno() {
        return cierreNocturno;
    }

    public void setCierreNocturno(String cierreNocturno) {
        this.cierreNocturno = cierreNocturno;
    }

    public Integer getTelefonoTaller() {
        return telefonoTaller;
    }

    public void setTelefonoTaller(Integer telefonoTaller) {
        this.telefonoTaller = telefonoTaller;
    }

    public String getAperturaExpress() {
        return aperturaExpress;
    }

    public void setAperturaExpress(String aperturaExpress) {
        this.aperturaExpress = aperturaExpress;
    }

    public Integer getAtencionesExpress() {
        return atencionesExpress;
    }

    public void setAtencionesExpress(Integer atencionesExpress) {
        this.atencionesExpress = atencionesExpress;
    }

    public String getAperturaDiurno() {
        return aperturaDiurno;
    }

    public void setAperturaDiurno(String aperturaDiurno) {
        this.aperturaDiurno = aperturaDiurno;
    }

    public Integer getAtencionesNocturno() {
        return atencionesNocturno;
    }

    public void setAtencionesNocturno(Integer atencionesNocturno) {
        this.atencionesNocturno = atencionesNocturno;
    }

    public String getCierreExpress() {
        return cierreExpress;
    }

    public void setCierreExpress(String cierreExpress) {
        this.cierreExpress = cierreExpress;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Integer getAtencionesDiurno() {
        return atencionesDiurno;
    }

    public void setAtencionesDiurno(Integer atencionesDiurno) {
        this.atencionesDiurno = atencionesDiurno;
    }

    public String getDireccionTaller() {
        return direccionTaller;
    }

    public void setDireccionTaller(String direccionTaller) {
        this.direccionTaller = direccionTaller;
    }

    public Integer getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(Integer idTaller) {
        this.idTaller = idTaller;
    }

    public String getCierreDiurno() {
        return cierreDiurno;
    }

    public void setCierreDiurno(String cierreDiurno) {
        this.cierreDiurno = cierreDiurno;
    }
}
