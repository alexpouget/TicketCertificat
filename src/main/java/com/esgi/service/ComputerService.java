package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.Computer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface ComputerService {

    List<Computer> findAllComputer();
    Computer findOneComputer(int id);
    Computer newComputer(Computer computer);
    Computer updateComputer(Computer computer);
    void deleteComputer(int id);
}
