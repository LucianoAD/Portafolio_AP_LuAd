/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.anselmino.backend.Repository;

import com.anselmino.backend.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luciano Anselmino
 */
public interface IContactRepository extends JpaRepository<Contact,Long>{
    
}
