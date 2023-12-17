package com.bsuir.service;


import com.bsuir.dao.CompanyDao;
import com.bsuir.dao.CompanyDaoImpl;
import com.bsuir.entity.Company;
import org.hibernate.HibernateError;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    CompanyDao companyDao = new CompanyDaoImpl();

    public CompanyServiceImpl() {}

    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try {
            companyDao.addCompany(company);
            isAdded = true;
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        try {
            if (companyDao.updateCompany(company))
                isUpdated = true;
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCompany(int id) {
        boolean isDeleted = false;
        try {
            if (companyDao.deleteCompany(id))
                isDeleted = true;
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return isDeleted;
    }

    @Override
    public List<Company> showCompanies() {
        List<Company> companies = null;
        try {
            companies = companyDao.showCompanies();
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return companies;
    }

    @Override
    public Company findCompanyById(int id) {
        Company company = null;
        try {
            company = companyDao.findCompanyById(id);
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return company;
    }

    @Override
    public Company findCompanyByName(String name) {
        Company company = null;
        try {
            company = companyDao.findCompanyByName(name);
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return company;
    }
}

