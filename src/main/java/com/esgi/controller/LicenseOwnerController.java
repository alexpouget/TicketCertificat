package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.LicenseOwner;
import com.esgi.entity.Role;
import com.esgi.service.LicenseOwnerService;
import com.esgi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController
@RequestMapping(value="/api/licenseowner")
public class LicenseOwnerController {

    @Autowired
    LicenseOwnerService licenseOwnerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<LicenseOwner> getAllLicenseOwner(){
        return licenseOwnerService.findAllLicenseOwner();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public LicenseOwner getLicenseOwner(@PathVariable int id){
        return licenseOwnerService.findOneLicenseOwner(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public LicenseOwner addLicenseOwner(@RequestBody LicenseOwner licenseOwner){
        return licenseOwnerService.newLicenseOwner(licenseOwner);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public LicenseOwner updateLicenseOwner(@PathVariable int id,@RequestBody LicenseOwner licenseOwner){
        return licenseOwnerService.updateLicenseOwner(licenseOwner);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteLicenseOwner(@PathVariable int id){
        licenseOwnerService.deleteLicenseOwner(id);
    }

}
