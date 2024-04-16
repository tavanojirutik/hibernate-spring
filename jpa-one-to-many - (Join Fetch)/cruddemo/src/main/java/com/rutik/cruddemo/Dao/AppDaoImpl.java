package com.rutik.cruddemo.Dao;

import com.rutik.cruddemo.entity.Course;
import com.rutik.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl implements  AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructerById(int theId) {
        return entityManager.find(Instructor.class , theId);
    }


    //Below Method Is use in "LAZY"
    @Override
    public List<Course> findCouesesByInstructerID(int theId) {

        //Create A Query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id=:data",Course.class);
        query.setParameter("data" ,theId);

        //execute Query
        List<Course> courses = query.getResultList();
        return courses;
    }


    //JoinFetch Below Method
    @Override
    public Instructor JoinInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "Select i from Instructor  i "+
                        "JOIN FETCH i.courses "+
                        "JOIN FETCH i.instructorDetail "+
                        "where i.id=:data", Instructor.class);
        query.setParameter("data" , theId);

        //execute Query
        Instructor instructor = query.getSingleResult();
        return instructor;
    }
}
