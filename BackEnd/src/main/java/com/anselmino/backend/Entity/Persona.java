package com.anselmino.backend.Entity;


import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 50, message = "El nombre ingresado debe tener entre 1 y 50 carácteres")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "La longitud del apellido debe ser de entre 1 a 50 carácteres")
    private String apellido;
    private String cv;
    private String imgbackground;
    private String img;  
}
