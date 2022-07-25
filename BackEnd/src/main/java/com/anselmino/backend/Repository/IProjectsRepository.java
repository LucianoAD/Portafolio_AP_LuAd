package com.anselmino.backend.Repository;

import com.anselmino.backend.Entity.Projects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectsRepository extends JpaRepository<Projects, Integer> {
    public Optional<Projects> findByTitle (String title);
    public boolean existsByTitle(String title);
    }
