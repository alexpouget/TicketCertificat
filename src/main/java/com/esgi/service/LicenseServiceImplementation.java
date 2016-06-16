package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.License;
import com.esgi.repository.CompanyRepository;
import com.esgi.repository.LicenseRepository;
import com.esgi.repository.SoftwareRepository;
import com.esgi.repository.TypeLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public class LicenseServiceImplementation implements LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;
    @Autowired
    private TypeLicenseRepository typeLicenseRepository;
    @Autowired
    private SoftwareRepository softwareRepository;

    @Override
    public void deleteLicense(int id) {
        licenseRepository.delete(id);
    }

    @Override
    public List<License> findAllLicense() {
        return licenseRepository.findAll();
    }

    @Override
    public License findOneLicense(int id) {
        return licenseRepository.findOne(id);
    }

    @Override
    public License newLicense(License license) {
        License license1 = new License();
        license1.setSoftware(softwareRepository.findOne(license.getSoftware().getId()));
        license1.setTypeLicense(typeLicenseRepository.findOne(license.getTypeLicense().getId()));
        return licenseRepository.save(license1);
    }

    @Override
    public License updateLicense(License license) {
        License license1 = new License();
        license1.setId(license.getId());
        license1.setSoftware(softwareRepository.findOne(license.getSoftware().getId()));
        license1.setTypeLicense(typeLicenseRepository.findOne(license.getTypeLicense().getId()));
        return licenseRepository.save(license1);
    }

    @Override
    public License findOneLicenseBysoftAndType(int id, int type) {
        return licenseRepository.getLicenseBysoftAndType(id,type);
    }
}
