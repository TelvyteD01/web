package com.bsuir.service;


import com.bsuir.dao.PersonDao;
import com.bsuir.dao.PersonDaoImpl;
import com.bsuir.entity.Person;
import org.hibernate.HibernateError;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    PersonDao personDao = new PersonDaoImpl();

    public PersonServiceImpl() {}

    @Override
    public boolean addPerson(Person person) {
        boolean isAdded = false;
        try {
            if (personDao.addPerson(person))
                isAdded = true;
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return isAdded;
    }

    @Override
    public boolean updatePerson(Person person) {
        boolean isUpdated = false;
        try {
            if (personDao.updatePerson(person))
                isUpdated = true;
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deletePerson(int id) {
        boolean isDeleted = false;
        try {
            if (personDao.deletePerson(id))
                isDeleted = true;
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return isDeleted;
    }

    @Override
    public List<Person> showPeople() {
        List<Person> people = null;
        try {
            people = personDao.showPeople();
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return people;
    }

    @Override
    public Person findPersonById(int id) {
        Person person = null;
        try {
            person = personDao.findPersonById(id);
        }
        catch (HibernateError e) {
            System.out.println(e);
        }
        return person;
    }
}
