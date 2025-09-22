package com.portfolio.repository;

import com.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.tags ORDER BY p.displayOrder ASC")
    List<Project> findAllWithTags();
    
    List<Project> findAllByOrderByDisplayOrderAsc();
}