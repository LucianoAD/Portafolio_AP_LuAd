package com.anselmino.backend.Dto;

import com.sun.istack.NotNull;
import javax.validation.constraints.Size;

public class dtoPersona {
    @NotNull
    @Size(min = 1, max = 50, message = "El nombre ingresado debe tener entre 1 y 50 carácteres")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "La longitud del apellido debe ser de entre 1 a 50 carácteres")
    private String apellido;
    private String cv;
    private String imgbackground;
    private String img;
    
    //Constructores

    public dtoPersona(String nombre, String apellido, String cv, String imgbackground, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cv = cv;
        this.imgbackground = imgbackground;
        this.img = img;
    }
    
     //Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getImgbackground() {
        return imgbackground;
    }

    public void setImgbackground(String imgbackground) {
        this.imgbackground = imgbackground;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
