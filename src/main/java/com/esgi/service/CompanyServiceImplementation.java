package com.esgi.service;

import com.esgi.entity.Company;
import com.esgi.entity.Role;
import com.esgi.repository.CompanyRepository;
import com.esgi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alex on 02/06/2016.
 */
@Service
public class CompanyServiceImplementation implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company findOneCompany(int id) {
        return companyRepository.findOne(id);
    }

    @Override
    public Company newCompany(Company company) {
        Company company1 = new Company();
        company1.setName(company.getName());
        company1.setAdress(company.getAdress());
        return companyRepository.save(company1);
    }

    @Override
    public Company updateCompany(Company company) {
        Company company1 = new Company();
        company1.setId(company.getId());
        company1.setName(company.getName());
        company1.setAdress(company.getAdress());
        return companyRepository.save(company1);
    }

    @Override
    public void deleteCompany(int id) {
        companyRepository.delete(id);
    }
}
