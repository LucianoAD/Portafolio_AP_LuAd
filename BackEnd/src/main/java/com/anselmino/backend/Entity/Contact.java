package com.anselmino.backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Contact {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;
    private String gmail;
    private String git;
    private String linkedin;
    private String hotmail;
    
    //Contructores

    public Contact() {
    }

    public Contact(String gmail, String git, String linkedin, String hotmail) {
        this.gmail = gmail;
        this.git = git;
        this.linkedin = linkedin;
        this.hotmail = hotmail;
    }
    
}

