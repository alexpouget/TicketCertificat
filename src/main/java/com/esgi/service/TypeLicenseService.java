package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.License;
import com.esgi.entity.TypeLicense;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface TypeLicenseService {

    void deleteTypeLicense(int id);

    List<TypeLicense> findAllTypeLicense();

    TypeLicense findOneTypeLicense(int id);

    TypeLicense newTypeLicense(TypeLicense typeLicense);

    TypeLicense updateTypeLicense(TypeLicense typeLicense);
}
