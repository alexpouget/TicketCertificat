package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.License;
import com.esgi.entity.Role;
import com.esgi.service.LicenseService;
import com.esgi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController
@RequestMapping(value="/api/license")
public class LicenseController {

    @Autowired
    LicenseService licenseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<License> getAllLicense(){
        return licenseService.findAllLicense();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public License getLicense(@PathVariable int id){
        return licenseService.findOneLicense(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public License addLicense(@RequestBody License license){
        return licenseService.newLicense(license);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public License updateLicense(@PathVariable int id,@RequestBody License license){
        return licenseService.updateLicense(license);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteLicense(@PathVariable int id){
        licenseService.deleteLicense(id);
    }

}
