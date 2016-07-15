package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.Computer;
import com.esgi.repository.CompanyRepository;
import com.esgi.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public class ComputerServiceImplementation implements ComputerService {

    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Computer> findAllComputer() {
        return computerRepository.findAll();
    }

    @Override
    public Computer findOneComputer(int id) {
        return computerRepository.findOne(id);
    }

    @Override
    public Computer newComputer(Computer computer) {
        Computer computer1 = new Computer();
        computer1.setName(computer.getName());
        computer1.setCompany(companyRepository.findOne(computer.getCompany().getId()));
        return computerRepository.save(computer1);
    }

    @Override
    public Computer updateComputer(Computer computer) {
        Computer computer1 = new Computer();
        computer1.setId(computer.getId());
        computer1.setName(computer.getName());
        computer1.setCompany(companyRepository.findOne(computer.getCompany().getId()));
        return computerRepository.save(computer1);
    }

    @Override
    public void deleteComputer(int id) {
        computerRepository.delete(id);
    }
}
