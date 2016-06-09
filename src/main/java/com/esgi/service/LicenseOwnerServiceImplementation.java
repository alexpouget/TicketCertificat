package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.LicenseOwner;
import com.esgi.repository.CompanyRepository;
import com.esgi.repository.ComputerRepository;
import com.esgi.repository.LicenseOwnerRepository;
import com.esgi.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public class LicenseOwnerServiceImplementation implements LicenseOwnerService {

    @Autowired
    private LicenseOwnerRepository licenseOwnerRepository;

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public void deleteLicenseOwner(int id) {
        licenseOwnerRepository.delete(id);
    }

    @Override
    public List<LicenseOwner> findAllLicenseOwner() {
        return licenseOwnerRepository.findAll();
    }

    @Override
    public LicenseOwner findOneLicenseOwner(int id) {
        return licenseOwnerRepository.findOne(id);
    }

    @Override
    public LicenseOwner newLicenseOwner(LicenseOwner licenseOwner) {
        LicenseOwner licenseOwner1 = new LicenseOwner();
        licenseOwner1.setDateDebut(licenseOwner.getDateDebut());
        licenseOwner1.setDateExpiration(licenseOwner.getDateExpiration());
        licenseOwner1.setComputer(computerRepository.findOne(licenseOwner.getComputer().getId()));
        licenseOwner1.setCompany(companyRepository.findOne(licenseOwner.getCompany().getId()));
        licenseOwner1.setLicense(licenseRepository.findOne(licenseOwner.getLicense().getId()));
        return licenseOwnerRepository.save(licenseOwner1);
    }

    @Override
    public LicenseOwner updateLicenseOwner(LicenseOwner licenseOwner) {
        LicenseOwner licenseOwner1 = new LicenseOwner();
        licenseOwner1.setId(licenseOwner.getId());
        licenseOwner1.setDateDebut(licenseOwner.getDateDebut());
        licenseOwner1.setDateExpiration(licenseOwner.getDateExpiration());
        licenseOwner1.setComputer(computerRepository.findOne(licenseOwner.getComputer().getId()));
        licenseOwner1.setCompany(companyRepository.findOne(licenseOwner.getCompany().getId()));
        licenseOwner1.setLicense(licenseRepository.findOne(licenseOwner.getLicense().getId()));
        return licenseOwnerRepository.save(licenseOwner1);
    }
}
