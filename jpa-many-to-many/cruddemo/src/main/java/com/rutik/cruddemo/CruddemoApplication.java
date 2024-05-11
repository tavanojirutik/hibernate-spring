package com.rutik.cruddemo;

import com.rutik.cruddemo.Dao.AppDao;
import com.rutik.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO) {

		return runner -> {

				createCourseAndStudents(appDAO);

		};
	}


	private void createCourseAndStudents(AppDao appDAO) {

		//Create a Course
		Course tempCourse = new Course("Java - The King Of Software Industry");

		//Create a Student
		Student tempStudent1 = new Student("Virat" , "Pandu" , "vp@mail.com");
		Student tempStudent2 = new Student("Rohit" , "sharma" , "rs@mail.com");

		tempCourse.	addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving the course : "+tempCourse);
		System.out.println("associated student: "+tempCourse.getStudents());

		appDAO.savex(tempCourse);

		System.out.println("Done");

	}



}
