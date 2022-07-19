package com.anselmino.backend.Controller;

import com.anselmino.backend.Entity.Persona;
import com.anselmino.backend.Interface.IPersonaService;
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

public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
 
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
    ipersonaService.savePersona(persona);
    return "La persona fue creada correctamente";
}

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
public String deletePersona(@PathVariable Long id ){
    ipersonaService.deletePersona(id);
    return "La persona fue eliminada correctamente";
}

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("cv") String nuevoCv,
            @RequestParam("imgbackground") String nuevaImgBackground,
            @RequestParam("img") String nuevaImg,
            @RequestParam("imgaboutme") String nuevaImgAboutMe,
            @RequestParam("mydescription") String nuevaMyDescription,
            @RequestParam("myinterest1") String nuevoMyInterest1,
            @RequestParam("myinterest2") String nuevoMyInterest2,
            @RequestParam("myinterest3") String nuevoMyInterest3,
            @RequestParam("myinterest4") String nuevoMyInterest4) {

        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setCv(nuevoCv);
        persona.setImgbackground(nuevaImgBackground);
        persona.setImg(nuevaImg);
        persona.setImgaboutme(nuevaImgAboutMe);
        persona.setMydescription(nuevaMyDescription);
        persona.setMyinterest1(nuevoMyInterest1);
        persona.setMyinterest2(nuevoMyInterest2);
        persona.setMyinterest3(nuevoMyInterest3);
        persona.setMyinterest4(nuevoMyInterest4);

        ipersonaService.savePersona(persona);
        return persona;
    }

@GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }

        }
