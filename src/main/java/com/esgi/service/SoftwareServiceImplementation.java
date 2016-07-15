package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.Software;
import com.esgi.repository.CompanyRepository;
import com.esgi.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public class SoftwareServiceImplementation implements SoftwareService {

    @Autowired
    private SoftwareRepository softwareRepository;

    @Override
    public List<Software> findAllSoftware() {
        return softwareRepository.findAll();
    }

    @Override
    public Software findOneSoftware(int id) {
        return softwareRepository.findOne(id);
    }

    @Override
    public void deleteSoftware(int id) {
        softwareRepository.delete(id);
    }

    @Override
    public Software newSoftware(Software software) {
        Software software1 = new Software();
        software1.setName(software.getName());
        return softwareRepository.save(software1);
    }

    @Override
    public Software updateSoftware(Software software) {
        Software software1 = new Software();
        software1.setId(software.getId());
        software1.setName(software.getName());
        return softwareRepository.save(software1);
    }
}
