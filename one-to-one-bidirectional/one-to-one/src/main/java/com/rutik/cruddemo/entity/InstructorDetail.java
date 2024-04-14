package com.rutik.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_Detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "YoutubeChannel")
    private String YoutubeChannel;
    @Column(name = "hobby")
    private String hobby;


    /*@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_fk")
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public InstructorDetail() {
    }

    public InstructorDetail(int id, String youtubeChannel, String hobby) {
        this.id = id;
        YoutubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return YoutubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        YoutubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
