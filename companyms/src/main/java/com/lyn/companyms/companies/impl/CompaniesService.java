package com.lyn.companyms.companies.impl;


import com.lyn.companyms.companies.Company;
import com.lyn.companyms.companies.ICompaniesRepository;
import com.lyn.companyms.companies.ICompaniesService;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesService implements ICompaniesService {
    ICompaniesRepository companiesRepository;

    public CompaniesService(ICompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public List<Company> findAllCompanies() {
        return (companiesRepository.findAll());
    }

    @Override
    public Company findCompanyById(Long id) {
        return (companiesRepository.findById(id).orElse(null));
    }

    @Override
    public void createCompany(Company company) {
        companiesRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if (companiesRepository.existsById(id)) {
            companiesRepository.deleteById(id);
            return (true);
        } else {
            return (false);
        }
    }
    @Override
    public boolean updateCompany(Long id, Company updateCompany) {
        Optional<Company> optionalCompany = companiesRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.update(updateCompany);
            companiesRepository.save(company);
            return (true);
        }
        return false;
    }
}
