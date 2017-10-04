package com.taskcar.db.model;

/**
 * Created by Hudeya on 1/08/2017.
 */

public class Car {
    private int id;
    private String placa;
    private String dni;
    private String marca;
    private String modelo;
    private String anio;


    public Car (){

    }

    public Car (int id, String placa, String dni, String marca, String modelo, String anio){
        this.id = id ;
        this.placa= placa;
        this.dni = dni;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public Car (String placa, String dni, String marca, String modelo , String anio){
        this.placa = placa;
        this.dni = dni;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }


    public Car (String placa, String dni, String marca, String modelo){
        this.placa = placa;
        this.dni= dni;
        this.marca= marca;
        this.modelo= modelo;

    }

    public Car (String placa, String marca, String modelo){
        this.placa = placa;
        this.marca = marca;
        this.modelo= modelo;

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
