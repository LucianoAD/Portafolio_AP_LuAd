package com.anselmino.backend.Service;

import com.anselmino.backend.Entity.Projects;
import com.anselmino.backend.Repository.IProjectsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional 
public class ImpProjectsService {
    @Autowired IProjectsRepository iProjectsRepository;
    
    public List<Projects> list(){
         return iProjectsRepository.findAll();
     }//arma una lista de projects
     
     public Optional<Projects> getOne(int id){
         return iProjectsRepository.findById(id);
     }
     
     public Optional<Projects> getByTitle(String title){
         return iProjectsRepository.findByTitle(title);
     }
     
     public void save(Projects proj){
         iProjectsRepository.save(proj);
     }
     
     public void delete(int id){
         iProjectsRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iProjectsRepository.existsById(id);
     }
     
     public boolean existsByTitle(String title){
         return iProjectsRepository.existsByTitle(title);
     }
}
