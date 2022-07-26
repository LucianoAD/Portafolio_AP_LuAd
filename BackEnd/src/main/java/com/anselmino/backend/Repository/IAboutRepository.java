package com.anselmino.backend.Repository;

import com.anselmino.backend.Entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    
@Repository
public interface IAboutRepository extends JpaRepository<About, Integer> {
    
    }