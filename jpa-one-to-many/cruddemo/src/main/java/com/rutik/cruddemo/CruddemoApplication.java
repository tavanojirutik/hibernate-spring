package com.rutik.cruddemo;

import com.rutik.cruddemo.Dao.AppDao;
import com.rutik.cruddemo.entity.Course;
import com.rutik.cruddemo.entity.Instructor;
import com.rutik.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDAO) {

		return runner -> {
			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDao appDAO) {

		Instructor tempInstructer = new
				Instructor("Rutik" ,"Tavanoji","rt@mail.com");

		InstructorDetail tempInstructorDetail = new
				InstructorDetail("gogoTube","Karate");

		tempInstructer.setInstructorDetail(tempInstructorDetail);

		//Create Some Course

		Course tempCourse1 = new Course("Java oops Concepts");
		Course tempCourse2 = new Course("Python oops Concepts");
		Course tempCourse3 = new Course("React Fundamentals");

		tempInstructer.add(tempCourse1);
		tempInstructer.add(tempCourse2);
		tempInstructer.add(tempCourse3);

		//Save Instructer
		System.out.println("Saving Instructor : "+ tempInstructer);
		System.out.println("The Course : "+tempInstructer.getCourses());
		appDAO.save(tempInstructer);
		System.out.println("Done!");
	}

}
