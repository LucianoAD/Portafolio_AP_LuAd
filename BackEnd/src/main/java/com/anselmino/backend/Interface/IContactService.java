/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.anselmino.backend.Interface;

import com.anselmino.backend.Entity.Contact;
import java.util.List;

/**
 *
 * @author Luciano Anselmino
 */
public interface IContactService {
     //Traer lista de contacts
    public List<Contact> getContact ();
    //guardar objeto del tipo contact
    public void saveContact(Contact contact);
    //eliminar una contact
    public void deleteContact(Long Id);
    //buscar una contact
    public Contact findContact(Long Id);
    
}
