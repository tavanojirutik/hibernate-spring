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

    public InstructorDetail() {

    }
    public InstructorDetail(int id, String youtubeChannel, String hobby) {
        this.id = id;
        YoutubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public InstructorDetail(String tSyou, String cricket) {
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

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + YoutubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
