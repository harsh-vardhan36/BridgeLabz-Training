package com.json.jsonToXml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {
	public static void main(String[] args) throws Exception {
		String json = "{\"user\":{\"name\":\"Harsh\", \"age\":22}}";

		ObjectMapper jsonMapper = new ObjectMapper();
		JsonNode node = jsonMapper.readTree(json);

		XmlMapper xmlMapper = new XmlMapper();
		String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
		System.out.println(xml);
	}
}