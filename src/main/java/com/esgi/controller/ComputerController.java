package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.Company;
import com.esgi.entity.Computer;
import com.esgi.entity.Role;
import com.esgi.service.ComputerService;
import com.esgi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController
@RequestMapping(value="/api/computer")
public class ComputerController {

    @Autowired
    ComputerService computerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Computer> getAllComputer(){
        return computerService.findAllComputer();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public Computer getComputer(@PathVariable int id){
        return computerService.findOneComputer(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Computer addComputer(@RequestBody Computer computer){
        return computerService.newComputer(computer);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public Computer updateComputer(@PathVariable int id,@RequestBody Computer computer){
        return computerService.updateComputer(computer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteComputer(@PathVariable int id){
        computerService.deleteComputer(id);
    }

}
