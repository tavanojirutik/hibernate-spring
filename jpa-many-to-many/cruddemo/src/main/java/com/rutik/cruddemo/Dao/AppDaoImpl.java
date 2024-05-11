package com.rutik.cruddemo.Dao;

import com.rutik.cruddemo.entity.Course;
import com.rutik.cruddemo.entity.Instructor;
import com.rutik.cruddemo.entity.Student;
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

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class , theId);
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

    @Override
    @Transactional
    public void updateInstructer(Instructor tempInstructor) {
        entityManager.merge(tempInstructor); //Merge Is Can Update The Respective Value
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteInstructer(int theId) {

        Instructor tempInstructor = entityManager.find(Instructor.class,theId);

        //Get The Course
        List<Course> courses = tempInstructor.getCourses();

        //break associated of all courses for the instructor
        for (Course tempCourse : courses){
            tempCourse.setInstructor(null);
        }

        //delete the Instructor
        entityManager.remove(tempInstructor);

    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course tempCourse = entityManager.find(Course.class,theId);

        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void savex(Course course) {
        entityManager.persist(course);

    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    public Course findCourseAndReviewByCourseById(int theId) {

        //Create Query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.reviews "
                        + "where c.id = :data", Course.class);

        query.setParameter("data" , theId);

        //execute Query
        Course course = query.getSingleResult();
        return course;
    }
}
