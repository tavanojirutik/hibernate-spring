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

			//findInstructorWithCourceJoinFetch(appDAO);

			//findInstructorWithCourceJoinFetch();

			updateInstructerById(appDAO);

			updateCourseById(appDAO);
			
			deleteInstructerById(appDAO);

			deleteCourseByIds(appDAO);

		};
	}

	private void deleteCourseByIds(AppDao appDAO) {
		int theId = 8;
		appDAO.deleteCourseById(theId);
		System.out.println("Course Delete!");
	}

	private void deleteInstructerById(AppDao appDAO) {

		int theId = 4;
		System.out.println("Delete Instructor id : "+theId);
		appDAO.deleteInstructer(theId);
		System.out.println("Delete Done!");
	}


	//Update Course
	private void updateCourseById(AppDao appDAO) {
		int theId = 1;

		//find The Instructor
		System.out.println("Finding Course Id : "+ theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Course Is : "+tempCourse);

		//Update the Course
		System.out.println("Update Course Id : "+ theId);
		tempCourse.setTitle("Devops Full Course Zero To Hundred  ");
		appDAO.updateCourse(tempCourse);
		System.out.println("Done!");
	}


	//Update The Instructor
	private void updateInstructerById(AppDao appDAO) {
		int theId = 1;

		//find The Instructor
		System.out.println("Finding Instructor Id : "+ theId);
		Instructor tempInstructor = appDAO.findInstructerById(theId);

		//Update the Instructor
		System.out.println("Update Instructor Id : "+ theId);
		tempInstructor.setFirstName("Risi");
		appDAO.updateInstructer(tempInstructor);
		System.out.println("Done!");
	}



	/*private void findInstructorWithCourceJoinFetch(AppDao appDAO) {
		int theId=1;
		System.out.println("Finding Instructor Id : "+theId);

		Instructor theInstructer = appDAO.JoinInstructorByIdJoinFetch(theId);

		System.out.println("the Instructors : "+theInstructer);
		System.out.println("the associated Courses : "+theInstructer.getCourses());
		System.out.println("Done !");
	}*/

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
				Instructor("Pooja" ,"Jadhav","poojaJadjav@mail.com");

		InstructorDetail tempInstructorDetail = new
				InstructorDetail("HTML.Tube","langdi");

		tempInstructer.setInstructorDetail(tempInstructorDetail);

		//Create Some Course

		Course tempCourse1 = new Course("Coral Draw Full Fundamentals");
		Course tempCourse2 = new Course("Photoshop");
		Course tempCourse3 = new Course("Web kit AI");

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
