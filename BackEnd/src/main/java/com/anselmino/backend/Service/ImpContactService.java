package com.anselmino.backend.Service;

import com.anselmino.backend.Entity.Contact;
import com.anselmino.backend.Repository.IContactRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ImpContactService {
    @Autowired IContactRepository iContactRepository;
    
    public List<Contact> list(){
         return iContactRepository.findAll();
     }//arma una lista de contact
     
     public Optional<Contact> getOne(int id){
         return iContactRepository.findById(id);
     }
     
     public void save(Contact contact){
         iContactRepository.save(contact);
     }
     
     public void delete(int id){
         iContactRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iContactRepository.existsById(id);
     }
     
    
}