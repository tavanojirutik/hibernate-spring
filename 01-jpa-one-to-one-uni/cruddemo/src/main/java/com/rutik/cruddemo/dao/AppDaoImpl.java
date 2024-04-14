package com.rutik.cruddemo.dao;

import com.rutik.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl implements  AppDao{

    //Define Field for Entity Manager
    private EntityManager entityManager ;

    //inject entity manager using constructor injection
    @Autowired
    public AppDaoImpl (EntityManager ennEntityManager){
        this.entityManager = ennEntityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
        //persist (Save The Instructer)
    }

    @Override
    public Instructor findInstructerById(int theId) {
        return entityManager.find(Instructor.class , theId);
    }

    @Override
    @Transactional
    public void deleteInstructerByID(int theId) {

        Instructor tempInstructer = entityManager.find(Instructor.class ,theId);

        entityManager.remove(tempInstructer); //This is Also Delete the instructer details objet Because of Cascade.ALL

    }


}
