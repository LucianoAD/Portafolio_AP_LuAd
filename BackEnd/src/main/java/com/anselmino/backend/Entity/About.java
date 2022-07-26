package com.anselmino.backend.Entity;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class About {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;
    private String imgaboutme;
    @Size(max = 500, message = "Max. 500 caracteres")
    private String mydescription;
    @Size(max = 50, message = "Max. 1000 caracteres")
    private String myinterest1;
    @Size(max = 50, message = "Max. 1000 caracteres")
    private String myinterest2;
    @Size(max = 50, message = "Max. 1000 caracteres")
    private String myinterest3;
    @Size(max = 50, message = "Max. 1000 caracteres")
    private String myinterest4;
    
    //Constructores

    public About() {
    }

    public About(String imgaboutme, String mydescription, String myinterest1, String myinterest2, String myinterest3, String myinterest4) {
        this.imgaboutme = imgaboutme;
        this.mydescription = mydescription;
        this.myinterest1 = myinterest1;
        this.myinterest2 = myinterest2;
        this.myinterest3 = myinterest3;
        this.myinterest4 = myinterest4;
    }
    
}

 
