package com.anselmino.backend.Controller;

import com.anselmino.backend.Dto.dtoContact;
import com.anselmino.backend.Entity.Contact;
import com.anselmino.backend.Security.Controller.Mensaje;
import com.anselmino.backend.Service.ImpContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "https://frontproyectointegradorap.web.app")
public class ContactController {
    @Autowired ImpContactService impContactService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Contact>> list(){
        List<Contact> list = impContactService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Contact> getById(@PathVariable("id") int id){
        if(!impContactService.existsById(id))
            return new ResponseEntity(new Mensaje("La informacion de contacto no existe"), HttpStatus.NOT_FOUND);
        Contact contact = impContactService.getOne(id).get();
        return new ResponseEntity(contact, HttpStatus.OK);
    }
        
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impContactService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        impContactService.delete(id);
        return new ResponseEntity(new Mensaje("Informacion de contacto eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    
    public ResponseEntity<?> create(@RequestBody dtoContact dtocontact){      
        
        Contact contact = new Contact(dtocontact.getGmail(), dtocontact.getGit(), dtocontact.getLinkedin(), dtocontact.getHotmail());
        impContactService.save(contact);
        
        return new ResponseEntity(new Mensaje("Informacion de contacto creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoContact dtocontact){
        //Validamos si existe el ID
        if(!impContactService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        Contact contact = impContactService.getOne(id).get();
        contact.setGmail(dtocontact.getGmail());
        contact.setGit((dtocontact.getGit()));
        contact.setLinkedin((dtocontact.getLinkedin()));
        contact.setHotmail((dtocontact.getHotmail()));
        
        impContactService.save(contact);
        return new ResponseEntity(new Mensaje("La informacion de contacto fue actualizada"), HttpStatus.OK);
             
    }
}  

