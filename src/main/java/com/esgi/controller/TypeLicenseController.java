package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.License;
import com.esgi.entity.Role;
import com.esgi.entity.TypeLicense;
import com.esgi.service.LicenseService;
import com.esgi.service.RoleService;
import com.esgi.service.TypeLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController
@RequestMapping(value="/api/typelicense")
public class TypeLicenseController {

    @Autowired
    TypeLicenseService typeLicenseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<TypeLicense> getAllTypeLicense(){
        return typeLicenseService.findAllTypeLicense();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public TypeLicense getTypeLicense(@PathVariable int id){
        return typeLicenseService.findOneTypeLicense(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public TypeLicense addTypeLicense(@RequestBody TypeLicense typeLicense){
        return typeLicenseService.newTypeLicense(typeLicense);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public TypeLicense updateTypeLicense(@PathVariable int id,@RequestBody TypeLicense typeLicense){
        return typeLicenseService.updateTypeLicense(typeLicense);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteTypeLicense(@PathVariable int id){
        typeLicenseService.deleteTypeLicense(id);
    }

}
