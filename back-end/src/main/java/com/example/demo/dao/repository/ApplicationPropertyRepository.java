package com.example.demo.dao.repository;

import com.example.demo.dao.entity.ApplicationPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ApplicationPropertyRepository extends JpaRepository<ApplicationPropertyEntity,Long> {

    /**
     * Custom query method to find the property by name.
     * @param name Name of the property.
     * @return ApplicationPropertyEntity.
     */
    @Query(value = "SELECT * FROM appdata a WHERE a.propertyname = ?1 ORDER BY 1", nativeQuery = true)
    ApplicationPropertyEntity findByPropertyName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE ApplicationPropertyEntity a SET a.propertyvalue = ?1 WHERE a.id = ?2")
    void updateByPropertyId( double value, Long id);

}

