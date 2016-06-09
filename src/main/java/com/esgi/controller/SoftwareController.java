package com.esgi.controller;


import com.esgi.config.AppUserDetailsService;
import com.esgi.entity.Role;
import com.esgi.entity.Software;
import com.esgi.service.RoleService;
import com.esgi.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@RestController
@RequestMapping(value="/api/software")
public class SoftwareController {

    @Autowired
    SoftwareService softwareService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Software> getAllSoftware(){
        return softwareService.findAllSoftware();
    }

    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public Software getSoftware(@PathVariable int id){
        return softwareService.findOneSoftware(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Software addSoftware(@RequestBody Software software){
        return softwareService.newSoftware(software);
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public Software updateSoftware(@PathVariable int id,@RequestBody Software software){
        return softwareService.updateSoftware(software);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public void deleteSoftware(@PathVariable int id){
        softwareService.deleteSoftware(id);
    }

}
