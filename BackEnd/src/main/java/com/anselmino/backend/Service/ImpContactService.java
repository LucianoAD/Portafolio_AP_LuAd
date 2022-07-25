package com.anselmino.backend.Service;

import com.anselmino.backend.Entity.Contact;
import com.anselmino.backend.Interface.IContactService;
import com.anselmino.backend.Repository.IContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpContactService implements IContactService{
@Autowired IContactRepository icontactRepository;
    @Override
    public List<Contact> getContact() {
       List<Contact> contact = icontactRepository.findAll();
       return contact;
    }

    @Override
    public void saveContact(Contact contact) {
        icontactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long Id) {
         icontactRepository.deleteById(Id);
    }

    @Override
    public Contact findContact(Long Id) {
        Contact contact = icontactRepository.findById(Id).orElse(null);
                return contact; 
    }
    
}

