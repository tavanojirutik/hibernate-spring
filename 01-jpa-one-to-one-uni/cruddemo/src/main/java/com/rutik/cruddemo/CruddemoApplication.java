package com.rutik.cruddemo;

import com.rutik.cruddemo.dao.AppDao;
import com.rutik.cruddemo.entity.Instructor;
import com.rutik.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
public class CruddemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){

		return runner ->{
			//Add Data In Database
			createInstructor(appDao);
			//Show Data Using Id
			//findInstructer(appDao);
			//Delete Data from from Database using ID
			//deleteInstructer(appDao);
		};
	}

	/*private void deleteInstructer(AppDao appDao) {
		int theId=4;
		System.out.println("Deleteing Instructing Id : "+theId);
		appDao.deleteInstructerByID(theId);
		System.out.println("Data Delete Successfully : ");
	}*/

	/*private void findInstructer(AppDao appDao) {

		int theId =3;

		System.out.println("Finding Instructer Id : "+theId);
		Instructor tempinstructor = appDao.findInstructerById(theId);
		System.out.println("Instructer Data : "+tempinstructor);

		System.out.println("the Associated Instructer Only : "+ tempinstructor.getInstructorDetail());

	}*/

	private void createInstructor(AppDao appDao) {
		// Create Instructor
		Instructor tempInstructor = new Instructor();
		tempInstructor.setFirstName("Ankita");
		tempInstructor.setLastName("sing");
		tempInstructor.setEmail("as@gmail.com");

		// Create InstructorDetail
		InstructorDetail tempInstructorDetail = new InstructorDetail();
		tempInstructorDetail.setYoutubeChannel("FitTube");
		tempInstructorDetail.setHobby("coding");

		// Associate Instructor with InstructorDetail
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Save Instructor
		appDao.save(tempInstructor);
	}

	

}
