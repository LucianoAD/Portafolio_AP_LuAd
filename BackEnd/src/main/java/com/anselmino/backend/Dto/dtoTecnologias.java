package com.anselmino.backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoTecnologias {
    @NotBlank
    private String title;
    private String imgtech;
    @NotBlank
    private String perctech;
    
 //Constructores
public dtoTecnologias(String title, String imgtech, String perctech) {
        this.title = title;
        this.imgtech = imgtech;
        this.perctech = perctech;
    }
    
       
 //Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgtech() {
        return imgtech;
    }

    public void setImgtech(String imgtech) {
        this.imgtech = imgtech;
    }

    public String getPerctech() {
        return perctech;
    }

    public void setPerctech(String perctech) {
        this.perctech = perctech;
    }

    

    
       }
        
   

    
     

