package com.anselmino.backend.Service;

import com.anselmino.backend.Entity.About;
import com.anselmino.backend.Repository.IAboutRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ImpAboutService {
    @Autowired IAboutRepository iAboutRepository;
    
    public List<About> list(){
         return iAboutRepository.findAll();
     }//arma una lista de about
     
     public Optional<About> getOne(int id){
         return iAboutRepository.findById(id);
     }
     
     public void save(About about){
         iAboutRepository.save(about);
     }
     
     public void delete(int id){
         iAboutRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iAboutRepository.existsById(id);
     }
     
    
}

