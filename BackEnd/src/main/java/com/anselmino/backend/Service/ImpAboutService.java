package com.anselmino.backend.Service;

import com.anselmino.backend.Entity.About;
import com.anselmino.backend.Interface.IAboutService;
import com.anselmino.backend.Repository.IAboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpAboutService implements IAboutService{
@Autowired IAboutRepository iaboutRepository;
    @Override
    public List<About> getAbout() {
       List<About> about = iaboutRepository.findAll();
       return about;
    }

    @Override
    public void saveAbout(About about) {
        iaboutRepository.save(about);
    }

    @Override
    public void deleteAbout(Long Id) {
         iaboutRepository.deleteById(Id);
    }

    @Override
    public About findAbout(Long Id) {
        About about = iaboutRepository.findById(Id).orElse(null);
                return about; 
    }
    
}

