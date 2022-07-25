package com.anselmino.backend.Controller;

import com.anselmino.backend.Entity.Contact;
import com.anselmino.backend.Service.ImpContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

        
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ContactController {
    @Autowired ImpContactService icontactService;
    
    @GetMapping("/contact/traer")
    public List<Contact> getContact(){
        return icontactService.getContact();
    }
 
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/contact/crear")
    public String createContact(@RequestBody Contact contact){
    icontactService.saveContact(contact);
    return "La información de contacto fue ingresada correctamente";
}
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/contact/borrar/{id}")
public String deleteContact(@PathVariable Long id ){
    icontactService.deleteContact(id);
    return "La información de contacto de usuario fue eliminada correctamente";
}

   @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/contact/editar/{id}")
    public Contact editContact(@PathVariable Long id,
            @RequestParam("gmail") String nuevoGmail,
            @RequestParam("git") String nuevoGit,
            @RequestParam("linkedin") String nuevoLinkedin,
            @RequestParam("hotmail") String nuevoHotmail) {

        Contact contact = icontactService.findContact(id);
        contact.setGmail(nuevoGmail);
        contact.setGit(nuevoGit);
        contact.setLinkedin(nuevoLinkedin);
        contact.setHotmail(nuevoHotmail);
        
        icontactService.saveContact(contact);
        return contact;
    }
    
@GetMapping("/contact/traer/perfil")
    public Contact findContact(){
        return icontactService.findContact((long)1);
    }
    
        }

