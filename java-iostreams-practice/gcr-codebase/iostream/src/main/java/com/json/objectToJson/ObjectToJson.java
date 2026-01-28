package com.json.objectToJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ObjectToJson {
	public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Car myCar = new Car("Tesla", "Model S", 2024);

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myCar);
        System.out.println("Problem 2 (Object to JSON):");
        System.out.println(json);
    }
}
