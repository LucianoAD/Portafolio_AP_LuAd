package com.anselmino.backend.Controller;

import com.anselmino.backend.Dto.dtoProjects;
import com.anselmino.backend.Entity.Projects;
import com.anselmino.backend.Security.Controller.Mensaje;
import com.anselmino.backend.Service.ImpProjectsService;
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
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectsController {
    @Autowired ImpProjectsService impProjectsService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Projects>> list(){
        List<Projects> list = impProjectsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Projects> getById(@PathVariable("id") int id){
        if(!impProjectsService.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.NOT_FOUND);
        Projects projects = impProjectsService.getOne(id).get();
        return new ResponseEntity(projects, HttpStatus.OK);
    }
        
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impProjectsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impProjectsService.delete(id);
        return new ResponseEntity(new Mensaje("skill eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    
    public ResponseEntity<?> create(@RequestBody dtoProjects dtoproj){      
        if(StringUtils.isBlank(dtoproj.getTitle()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impProjectsService.existsByTitle(dtoproj.getTitle()))
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Projects projects = new Projects(dtoproj.getTitle(), dtoproj.getTech(), dtoproj.getDescription(), dtoproj.getUrl());
        impProjectsService.save(projects);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProjects dtoproj){
        //Validamos si existe el ID
        if(!impProjectsService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(impProjectsService.existsByTitle(dtoproj.getTitle()) && impProjectsService.getByTitle(dtoproj.getTitle()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproj.getTitle()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Projects projects = impProjectsService.getOne(id).get();
        projects.setTitle(dtoproj.getTitle());
        projects.setTech((dtoproj.getTech()));
        projects.setDescription((dtoproj.getDescription()));
        projects.setUrl((dtoproj.getUrl()));
        
        impProjectsService.save(projects);
        return new ResponseEntity(new Mensaje("La skill fue actualizada"), HttpStatus.OK);
             
    }
}  

