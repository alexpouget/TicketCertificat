package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public interface CompanyService {

    List<Company> findAllCompany();
    Company findOneCompany(int id);
    Company newCompany(Company company);
    Company updateCompany(Company company);
    void deleteCompany(int id);
}
