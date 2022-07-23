package com.anselmino.backend.Interface;

import com.anselmino.backend.Entity.About;
import java.util.List;

public interface IAboutService {
     //Traer lista de abouts
    public List<About> getAbout ();
    //guardar objeto del tipo about
    public void saveAbout(About about);
    //eliminar una about
    public void deleteAbout(Long Id);
    //buscar una about
    public About findAbout(Long Id);
    
}
