package com.anselmino.backend.Security.Service;

import com.anselmino.backend.Security.Entity.Rol;
import com.anselmino.backend.Security.Enums.RolNombre;
import com.anselmino.backend.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //mantiene la persistencia  entre el backend y la base de datos
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
    
}
