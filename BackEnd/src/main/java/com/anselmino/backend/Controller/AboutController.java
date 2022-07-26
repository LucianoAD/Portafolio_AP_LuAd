package com.anselmino.backend.Controller;

import com.anselmino.backend.Dto.dtoAbout;
import com.anselmino.backend.Entity.About;
import com.anselmino.backend.Security.Controller.Mensaje;
import com.anselmino.backend.Service.ImpAboutService;
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
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:4200")
public class AboutController {
    @Autowired ImpAboutService impAboutService;
    
    @GetMapping("/list")
    public ResponseEntity<List<About>> list(){
        List<About> list = impAboutService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<About> getById(@PathVariable("id") int id){
        if(!impAboutService.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.NOT_FOUND);
        About about = impAboutService.getOne(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }
        
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impAboutService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        impAboutService.delete(id);
        return new ResponseEntity(new Mensaje("Perfil eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    
    public ResponseEntity<?> create(@RequestBody dtoAbout dtoabout){      
        
        About about = new About(dtoabout.getImgaboutme(), dtoabout.getMydescription(), dtoabout.getMyinterest1(), dtoabout.getMyinterest2(),dtoabout.getMyinterest3(),dtoabout.getMyinterest4());
        impAboutService.save(about);
        
        return new ResponseEntity(new Mensaje("Informacion correctamente creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAbout dtoabout){
        //Validamos si existe el ID
        if(!impAboutService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        About about = impAboutService.getOne(id).get();
        about.setImgaboutme(dtoabout.getImgaboutme());
        about.setMydescription((dtoabout.getMydescription()));
        about.setMyinterest1((dtoabout.getMyinterest1()));
        about.setMyinterest2((dtoabout.getMyinterest2()));
        about.setMyinterest3((dtoabout.getMyinterest3()));
        about.setMyinterest4((dtoabout.getMyinterest4()));
     
        
        impAboutService.save(about);
        return new ResponseEntity(new Mensaje("La informacion fue actualizada"), HttpStatus.OK);
             
    }
}  

