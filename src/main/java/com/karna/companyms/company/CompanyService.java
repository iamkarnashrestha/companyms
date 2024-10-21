package com.karna.companyms.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();
    void createCompany(Company job);

    Company findCompanyByID(Long id);

    boolean deleteById(Long id);

    boolean updateCompany(Long id, Company company);
}
