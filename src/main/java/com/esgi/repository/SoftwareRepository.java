package com.esgi.repository;


import com.esgi.entity.Company;
import com.esgi.entity.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alex on 29/05/2016.
 */
@Repository
public interface SoftwareRepository extends JpaRepository<Software,Integer> {

}
