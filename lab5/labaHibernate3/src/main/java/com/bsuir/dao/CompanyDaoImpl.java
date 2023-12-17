package com.bsuir.dao;


import com.bsuir.entity.Company;
import com.bsuir.sessionFactory.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    public CompanyDaoImpl() {
    }

    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(company);
            tx.commit();
            session.close();
            isAdded = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        try {
            // Тут нужно обновление
            isUpdated = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCompany(int id) {
        boolean isDeleted = false;
        try {
            // Тут нужно удаление
            isDeleted = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public Company findCompanyById(int id) {
        Company company = null;
        try {
            //Тут нужен поиск
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return company;
    }

    @Override
    public Company findCompanyByName(String name) {
        Company company = null;
        try {
            // Тут нужен поиск по имени
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return company;
    }

    @Override
    public List<Company> showCompanies() {
        List<Company> companies = (List<Company>)SessionFactoryImpl.getSessionFactory().openSession().createQuery("From Company").list();
        return companies;
    }
}
