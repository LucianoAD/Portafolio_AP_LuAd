package com.anselmino.backend.Repository;

import com.anselmino.backend.Entity.Tecnologias;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnologiasRepository extends JpaRepository<Tecnologias, Integer> {
    public Optional<Tecnologias> findByTitle (String title);
    public boolean existsByTitle(String title);
}
