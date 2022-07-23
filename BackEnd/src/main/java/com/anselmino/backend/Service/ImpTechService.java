package com.anselmino.backend.Service;

import com.anselmino.backend.Entity.Tecnologias;
import com.anselmino.backend.Repository.ITecnologiasRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ImpTechService {
    @Autowired ITecnologiasRepository iTecnologiasRepository;
    
    public List<Tecnologias> list(){
         return iTecnologiasRepository.findAll();
     }//arma una lista de tecnologias
     
     public Optional<Tecnologias> getOne(int id){
         return iTecnologiasRepository.findById(id);
     }
     
     public Optional<Tecnologias> getByTitle(String title){
         return iTecnologiasRepository.findByTitle(title);
     }
     
     public void save(Tecnologias tech){
         iTecnologiasRepository.save(tech);
     }
     
     public void delete(int id){
         iTecnologiasRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iTecnologiasRepository.existsById(id);
     }
     
     public boolean existsByTitle(String title){
         return iTecnologiasRepository.existsByTitle(title);
     }
}

