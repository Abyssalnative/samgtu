package com.university.university;

import com.university.university.model.SemesterCycleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
		SemesterCycleService sc = new SemesterCycleService();
		sc.printNowTime();
	}



}
