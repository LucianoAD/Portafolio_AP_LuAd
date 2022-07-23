package com.anselmino.backend.Controller;

import com.anselmino.backend.Entity.About;
import com.anselmino.backend.Interface.IAboutService;
import com.anselmino.backend.Service.ImpAboutService;
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

public class AboutController {
    @Autowired ImpAboutService iaboutService;
    
    @GetMapping("/about/traer")
    public List<About> getAbout(){
        return iaboutService.getAbout();
    }
 
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/about/crear")
    public String createAbout(@RequestBody About about){
    iaboutService.saveAbout(about);
    return "La informacion fue ingresada correctamente";
}
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/about/borrar/{id}")
public String deleteAbout(@PathVariable Long id ){
    iaboutService.deleteAbout(id);
    return "La informacion del usuario fue eliminada correctamente";
}

   @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/about/editar/{id}")
    public About editAbout(@PathVariable Long id,
            @RequestParam("imgaboutme") String nuevaImgAboutMe,
            @RequestParam("mydescription") String nuevaMyDescription,
            @RequestParam("myinterest1") String nuevoMyInterest1,
            @RequestParam("myinterest2") String nuevoMyInterest2,
            @RequestParam("myinterest3") String nuevoMyInterest3,
            @RequestParam("myinterest4") String nuevoMyInterest4) {

        About about = iaboutService.findAbout(id);
        about.setImgaboutme(nuevaImgAboutMe);
        about.setMydescription(nuevaMyDescription);
        about.setMyinterest1(nuevoMyInterest1);
        about.setMyinterest2(nuevoMyInterest2);
        about.setMyinterest3(nuevoMyInterest3);
        about.setMyinterest4(nuevoMyInterest4);

        iaboutService.saveAbout(about);
        return about;
    }
    
@GetMapping("/about/traer/perfil")
    public About findAbout(){
        return iaboutService.findAbout((long)1);
    }
    
        }


   
