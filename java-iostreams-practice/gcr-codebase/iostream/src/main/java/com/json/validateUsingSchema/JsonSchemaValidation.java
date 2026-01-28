package com.json.validateUsingSchema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import java.util.Set;

public class JsonSchemaValidation {
	public static void main(String[] args) throws Exception {
		String schemaStr = "{\"type\":\"object\",\"properties\":{\"email\":{\"type\":\"string\",\"format\":\"email\"}}}";
		String dataStr = "{\"email\":\"invalid-email\"}";

		ObjectMapper mapper = new ObjectMapper();
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
		JsonSchema schema = factory.getSchema(schemaStr);

		JsonNode node = mapper.readTree(dataStr);
		Set<com.networknt.schema.ValidationMessage> errors = schema.validate(node);

		if (errors.isEmpty())
			System.out.println(" Valid JSON");
		else
			errors.forEach(err -> System.out.println(" XX " + err.getMessage()));
	}
}