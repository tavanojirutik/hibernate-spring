package com.rutik.cruddemo.Dao;

import com.rutik.cruddemo.entity.Course;
import com.rutik.cruddemo.entity.Instructor;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInstructerById(int theId);


    //Below Method Is use in "LAZY"
    List<Course> findCouesesByInstructerID(int theId);

    //Below Method Join Fetch
    Instructor JoinInstructorByIdJoinFetch(int theId);
}
