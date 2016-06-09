package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.Company;
import com.esgi.entity.Role;
import com.esgi.service.CompanyService;
import com.esgi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController
@RequestMapping(value="/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Company> getAllCompany(){
        return companyService.findAllCompany();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public Company getCompany(@PathVariable int id){
        return companyService.findOneCompany(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Company addCompany(@RequestBody Company company){
        return companyService.newCompany(company);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public Company updateCompany(@PathVariable int id,@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteCompany(@PathVariable int id){
        companyService.deleteCompany(id);
    }

}
