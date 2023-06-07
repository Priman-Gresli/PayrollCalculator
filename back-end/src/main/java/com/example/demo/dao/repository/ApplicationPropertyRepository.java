package com.example.demo.dao.repository;

import com.example.demo.dao.entity.ApplicationPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ApplicationPropertyRepository extends JpaRepository<ApplicationPropertyEntity,Long> {

    @Query(value = "SELECT * FROM appdata a WHERE a.propertyname = ?1 ORDER BY 1", nativeQuery = true)
    ApplicationPropertyEntity findByPropertyName(String name);

    @Query(value = "UPDATE propertyname e SET e.field = :updatedValue WHERE e.id = :recordId")
    ApplicationPropertyEntity findByPropertyName(String name);
}

