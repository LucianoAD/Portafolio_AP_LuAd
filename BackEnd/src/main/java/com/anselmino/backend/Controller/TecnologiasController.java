package com.anselmino.backend.Controller;

import com.anselmino.backend.Dto.dtoTecnologias;
import com.anselmino.backend.Entity.Tecnologias;
import com.anselmino.backend.Security.Controller.Mensaje;
import com.anselmino.backend.Service.ImpTechService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/tech")
@CrossOrigin(origins = "https://frontproyectointegradorap.web.app")
public class TecnologiasController {
    @Autowired ImpTechService impTechService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Tecnologias>> list(){
        List<Tecnologias> list = impTechService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Tecnologias> getById(@PathVariable("id") int id){
        if(!impTechService.existsById(id))
            return new ResponseEntity(new Mensaje("La skill no existe"), HttpStatus.NOT_FOUND);
        Tecnologias tecnologias = impTechService.getOne(id).get();
        return new ResponseEntity(tecnologias, HttpStatus.OK);
    }
        
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impTechService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impTechService.delete(id);
        return new ResponseEntity(new Mensaje("skill eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoTecnologias dtotech){      
        if(StringUtils.isBlank(dtotech.getTitle()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impTechService.existsByTitle(dtotech.getTitle()))
            return new ResponseEntity(new Mensaje("La skill ya existe"), HttpStatus.BAD_REQUEST);
        
        Tecnologias tecnologias = new Tecnologias(dtotech.getTitle(), dtotech.getImgtech(), dtotech.getPerctech());
        impTechService.save(tecnologias);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTecnologias dtotech){
        //Validamos si existe el ID
        if(!impTechService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(impTechService.existsByTitle(dtotech.getTitle()) && impTechService.getByTitle(dtotech.getTitle()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtotech.getTitle()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Tecnologias tecnologias = impTechService.getOne(id).get();
        tecnologias.setTitle(dtotech.getTitle());
        tecnologias.setImgtech((dtotech.getImgtech()));
        tecnologias.setPerctech((dtotech.getPerctech()));
        
        impTechService.save(tecnologias);
        return new ResponseEntity(new Mensaje("La skill fue actualizada"), HttpStatus.OK);
             
    }
}  

