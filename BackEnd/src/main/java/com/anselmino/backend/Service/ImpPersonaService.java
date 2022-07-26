package com.anselmino.backend.Service;

import com.anselmino.backend.Entity.Persona;
import com.anselmino.backend.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ImpPersonaService {
    @Autowired IPersonaRepository iPersonaRepository;
    
    public List<Persona> list(){
         return iPersonaRepository.findAll();
     }//arma una lista de persona
     
     public Optional<Persona> getOne(int id){
         return iPersonaRepository.findById(id);
     }
     
     public void save(Persona persona){
         iPersonaRepository.save(persona);
     }
     
     public void delete(int id){
         iPersonaRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iPersonaRepository.existsById(id);
     }
     
    
}

