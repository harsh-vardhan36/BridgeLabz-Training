package com.json.jsonArray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

import jsonData.objectToJson.Car;
public class ListToJson {
	public static void main(String[] args) {
		try {
			List<Car> carList = new ArrayList<>();
			carList.add(new Car("Toyota", "Fortuner", 2030));
			carList.add(new Car("Mahindra", "Scorpio", 2028));

			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(carList);

			System.out.println(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}