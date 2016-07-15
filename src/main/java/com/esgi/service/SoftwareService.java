package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.Software;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface SoftwareService {

    List<Software> findAllSoftware();

    Software findOneSoftware(int id);

    void deleteSoftware(int id);

    Software newSoftware(Software software);

    Software updateSoftware(Software software);
}
