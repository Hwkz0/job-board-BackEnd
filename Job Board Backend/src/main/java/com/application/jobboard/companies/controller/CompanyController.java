package com.application.jobboard.companies.controller;


import com.application.jobboard.auth.exception.EntityNotFoundException;
import com.application.jobboard.companies.domain.Company;
import com.application.jobboard.companies.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final String entityType = "Company";

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/company/register")
    Company newCompany(@RequestBody Company registerCompany) {

        return companyRepository.save(registerCompany);

    }

    @GetMapping("/company/all-companies")
    List<Company> getAllCompanies() {

        return companyRepository.findAll();

    }

    @GetMapping("/company/{getCompanyById}")
    Company getCompanyById(Long getCompanyById){

        return companyRepository.findById(getCompanyById)
                .orElseThrow(() -> new EntityNotFoundException(getCompanyById, entityType));


    }


    @PutMapping("/company/update/{idOfCompanyToBeUpdated}")
    Company updateCompany(@RequestBody Company updateCompany, @PathVariable Long idOfCompanyToBeUpdated) {

        return companyRepository.findById(idOfCompanyToBeUpdated)
                .map(company -> {

                    company.setCompanyName(updateCompany.getCompanyName());

                    company.setCompanyEmailAddress(updateCompany.getCompanyEmailAddress());

                    company.setCompanyPassword(updateCompany.getCompanyPassword());

                    company.setCompanyPhoneNumber(updateCompany.getCompanyPhoneNumber());

                    return companyRepository.save(company);

                })

                .orElseThrow(() -> new EntityNotFoundException(idOfCompanyToBeUpdated, entityType));


    }


    @DeleteMapping("/company/delete/{deleteCompanyId}")
    String deleteCompany(@PathVariable Long deleteCompanyId) {

        if(companyRepository.existsById(deleteCompanyId)) {

            companyRepository.deleteById(deleteCompanyId);

            return "Company " + deleteCompanyId + " has been deleted";

        }
        else {
            throw new EntityNotFoundException(deleteCompanyId, entityType);
        }


    }



}
