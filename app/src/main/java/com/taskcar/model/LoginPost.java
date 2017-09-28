package com.taskcar.model;

/**
 * Created by Hudeya on 28/09/2017.
 */

public class LoginPost {
    private String DNI;
    private String password;


    public LoginPost(String DNI, String password){
        this.DNI = DNI;
        this.password= password;
    }
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        this.DNI = dNI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
