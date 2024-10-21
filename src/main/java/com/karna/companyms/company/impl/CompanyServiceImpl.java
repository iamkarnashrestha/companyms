package com.karna.companyms.company.impl;


import com.karna.companyms.company.Company;
import com.karna.companyms.company.CompanyRepository;
import com.karna.companyms.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
            companyRepository.save(company);
    }

    @Override
    public Company findCompanyByID(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> optionalJOb= companyRepository.findById(id);
        if(optionalJOb.isPresent()){
            Company j=optionalJOb.get();
            j.setDescription(company.getDescription());
            j.setName(company.getName());
            companyRepository.save(j);
            return true;
        }
        return false;


    }
}
