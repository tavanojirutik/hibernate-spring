package com.rutik.cruddemo;

import com.rutik.cruddemo.Dao.AppDao;
import com.rutik.cruddemo.entity.Course;
import com.rutik.cruddemo.entity.Instructor;
import com.rutik.cruddemo.entity.InstructorDetail;
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
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCource(appDAO);
			//findCourcesForInstructer(appDAO);

			findInstructorWithCourceJoinFetch(appDAO);
		};
	}

	private void findInstructorWithCourceJoinFetch(AppDao appDAO) {
		int theId=1;
		System.out.println("Finding Instructor Id : "+theId);

		Instructor theInstructer = appDAO.JoinInstructorByIdJoinFetch(theId);

		System.out.println("the Instructors : "+theInstructer);
		System.out.println("the associated Courses : "+theInstructer.getCourses());
		System.out.println("Done !");
	}

	/*private void findCourcesForInstructer(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding Instructor Id : "+theId);

		Instructor theInstructer = appDao.findInstructerById(theId);

		System.out.println("tempInstructer : "+ theInstructer);

		//find Courses for instructor
		System.out.println("Finding Courses for Instructer ID : "+ theId);
		List<Course> courses = appDao.findCouesesByInstructerID(theId);
		//associate The Object
		theInstructer.setCourses(courses);
		System.out.println("the associate courses : "+ theInstructer.getCourses());
		System.out.println("Done!");
	}*/


	/*private void findInstructorWithCource(AppDao appDAO) {
		int theId = 1;

		System.out.println("Finding Instructor Id : "+theId);

		Instructor tempInstructor = appDAO.findInstructerById(theId);

		System.out.println("tempInstructer : "+tempInstructor);
		System.out.println("The associated cource : "+ tempInstructor.getCourses());
		System.out.println("Done!");
	}*/

	/*private void createInstructorWithCourses(AppDao appDAO) {

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
	}*/



}
