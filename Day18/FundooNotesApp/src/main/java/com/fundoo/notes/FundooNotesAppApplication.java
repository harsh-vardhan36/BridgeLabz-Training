package com.fundoo.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // required for ReminderScheduler's @Scheduled poll loop
public class FundooNotesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundooNotesAppApplication.class, args);
	}

}
