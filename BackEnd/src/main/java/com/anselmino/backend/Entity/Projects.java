package com.anselmino.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Projects {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int Id;
    private String title;
    private String tech;
    private String description;
    private String url;
    
    //Constructores

    public Projects() {
    }

    public Projects(String title, String tech, String description, String url) {
        this.title = title;
        this.tech = tech;
        this.description = description;
        this.url = url;
    }
    
    
    
    
}
