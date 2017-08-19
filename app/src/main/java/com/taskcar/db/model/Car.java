package com.taskcar.db.model;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class Car {
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int anio;

    public Car() {

    }
    public Car (String placa, String marca, String modelo){
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);

    }
    public Car (int id, String placa, String marca, String modelo){
        this.setId(id);
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
