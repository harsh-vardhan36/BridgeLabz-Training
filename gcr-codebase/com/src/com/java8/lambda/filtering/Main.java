package com.java8.lambda.filtering;

import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;
public class Main {
public static void main(String [] args) {
List<Alert> alerts = new ArrayList<>();
alerts.add(new Alert("Critical","Patient is felling pain in chest"));
alerts.add(new Alert("Normal","Patient is felling pain in BACK"));
alerts.add(new Alert("Critical","Patient is felling pain in EYE"));

	Predicate<Alert> CriticalAlerts = 
			alert -> alert.getType().equals("Critical");
			
				for(Alert alert : alerts) {
		if(CriticalAlerts.test(alert)) {
			System.out.println(alert.getMessage());
		}
	}
}
}