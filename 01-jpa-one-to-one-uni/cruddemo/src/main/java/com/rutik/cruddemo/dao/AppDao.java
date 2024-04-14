package com.rutik.cruddemo.dao;

import com.rutik.cruddemo.entity.Instructor;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructerById(int theId);

    void deleteInstructerByID(int theId);
}
