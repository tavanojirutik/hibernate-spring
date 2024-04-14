package com.rutik.cruddemo;

import com.rutik.cruddemo.dao.AppDao;
import com.rutik.cruddemo.entity.Instructor;
import com.rutik.cruddemo.entity.InstructorDetail;
import jakarta.persistence.OneToOne;
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
	CommandLineRunner commandLineRunner(AppDao appDao){

		return runner->{
			OneToOneDataInsert(appDao);
		};
	}

	private void OneToOneDataInsert(AppDao appDao) {

		Instructor instructor = new Instructor();
		instructor.setFirstName("priti");
		instructor.setLastName("sing");
		instructor.setEmail("pp@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail();
		instructorDetail.setYoutubeChannel("Yoga_Tube");
		instructorDetail.setHobby("kabadi");

		instructor.setInstructorDetail(instructorDetail);
		instructorDetail.setInstructor(instructor);
		appDao.save(instructor);
		System.out.println("Data Save In Database!");

	}
}
