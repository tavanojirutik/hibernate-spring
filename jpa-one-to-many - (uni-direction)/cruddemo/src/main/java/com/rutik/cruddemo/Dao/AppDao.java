package com.rutik.cruddemo.Dao;

import com.rutik.cruddemo.entity.Course;
import com.rutik.cruddemo.entity.Instructor;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInstructerById(int theId);

    Course findCourseById(int theId);


    //Below Method Is use in "LAZY"
    List<Course> findCouesesByInstructerID(int theId);

    //Below Method Join Fetch
    Instructor JoinInstructorByIdJoinFetch(int theId);

    //Update Instructor
    void updateInstructer(Instructor tempInstructor);

    //update Course
    void updateCourse(Course course);

    void deleteInstructer(int theId);

    void deleteCourseById(int theId);

    //one To Many (Uni)

    void savex (Course course);

     Course findCourseAndReviewByCourseById(int theId);

}
