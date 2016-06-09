package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.License;
import com.esgi.entity.TypeLicense;
import com.esgi.repository.CompanyRepository;
import com.esgi.repository.LicenseRepository;
import com.esgi.repository.TypeLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public class TypeLicenseServiceImplementation implements TypeLicenseService {

    @Autowired
    private TypeLicenseRepository typeLicenseRepository;

    @Override
    public void deleteTypeLicense(int id) {
        typeLicenseRepository.delete(id);
    }

    @Override
    public List<TypeLicense> findAllTypeLicense() {
        return typeLicenseRepository.findAll();
    }

    @Override
    public TypeLicense findOneTypeLicense(int id) {
        return typeLicenseRepository.findOne(id);
    }

    @Override
    public TypeLicense newTypeLicense(TypeLicense typeLicense) {
        TypeLicense typeLicense1 = new TypeLicense();
        typeLicense1.setType(typeLicense.getType());
        return typeLicenseRepository.save(typeLicense1);
    }

    @Override
    public TypeLicense updateTypeLicense(TypeLicense typeLicense) {
        TypeLicense typeLicense1 = new TypeLicense();
        typeLicense1.setId(typeLicense.getId());
        typeLicense1.setType(typeLicense.getType());
        return typeLicenseRepository.save(typeLicense1);
    }
}
