package com.json.csvToJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class CsvToJson {
	public static void main(String[] args) throws Exception {
		String csvData = "id,name\n1,Harsh\n2,Vardhan";
		List<Map<String, String>> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new StringReader(csvData))) {
			String[] headers = br.readLine().split(",");
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				Map<String, String> map = new LinkedHashMap<>();
				for (int i = 0; i < headers.length; i++)
					map.put(headers[i], values[i]);
				list.add(map);
			}
		}
		System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(list));
	}
}