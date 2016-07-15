package com.esgi.repository;


import com.esgi.entity.Company;
import com.esgi.entity.License;
import com.esgi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 29/05/2016.
 */
@Repository
public interface LicenseRepository extends JpaRepository<License,Integer> {

    @Query("select l from License l where l.software.id=:id and l.typeLicense.id=:type")
    License getLicenseBysoftAndType(@Param("id") int id, @Param("type") int type);



}
