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
    private Long id;
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
}

 
