package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.LicenseOwner;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface LicenseOwnerService {

    void deleteLicenseOwner(int id);

    List<LicenseOwner> findAllLicenseOwner();

    LicenseOwner findOneLicenseOwner(int id);

    LicenseOwner newLicenseOwner(LicenseOwner licenseOwner);

    LicenseOwner updateLicenseOwner(LicenseOwner licenseOwner);
}
