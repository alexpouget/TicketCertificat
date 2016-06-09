package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.License;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface LicenseService {


    void deleteLicense(int id);

    List<License> findAllLicense();

    License findOneLicense(int id);

    License newLicense(License license);

    License updateLicense(License license);
}
