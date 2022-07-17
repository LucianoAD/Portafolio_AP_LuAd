package com.anselmino.backend.Interface;

import com.anselmino.backend.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer lista de personas
    public List<Persona> getPersona ();
    //guardar objeto del tipo persona
    public void savePersona(Persona persona);
    //eliminar una persona
    public void deletePersona(Long Id);
    //buscar una persona
    public Persona findPersona(Long Id);
    
    
    
}
