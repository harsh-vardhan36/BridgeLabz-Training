package com.json.mergeJsonFiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class JsonMerge {
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node1 = (ObjectNode) mapper.readTree(new File("src/main/java/jsonData/resources/file1.json"));
		ObjectNode node2 = (ObjectNode) mapper.readTree(new File("src/main/java/jsonData/resources/file2.json"));

		node1.setAll(node2); // node2 overwrites node1 keys if duplicate
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node1));
	}
}