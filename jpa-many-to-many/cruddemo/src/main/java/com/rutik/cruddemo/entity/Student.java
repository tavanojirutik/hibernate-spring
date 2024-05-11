package com.rutik.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Firstname")
    private String firstName;
    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "email")
    private String email;


    //Main Concept Many to Many Build //note:  Seam Copy pest in Student also Change "Join Column name"
    @ManyToMany(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH , CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;


    public Student(){

    }

    public Student(String firstName, String lastName , String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email= email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course theCourse){
        if (courses == null){
            courses = new ArrayList<>();
        }
        courses.add(theCourse);
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
