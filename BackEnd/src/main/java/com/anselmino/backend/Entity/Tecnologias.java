package com.anselmino.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Tecnologias {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int Id;
    private String title;
    private String imgtech;
    private String perctech;
    
    //Constructores
    
    public Tecnologias() {
    }
    public Tecnologias(String title, String imgtech, String perctech) {
        this.title = title;
        this.imgtech = imgtech;
        this.perctech = perctech;
    }

    
}
