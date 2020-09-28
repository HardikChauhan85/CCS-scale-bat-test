package com.scale.bat.framework.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONObject;

public class JsonParser {
	public String convertJsonToString(String filePath) {
		File reader = new File(filePath);
		byte[] encoded;
		String fileContent = null;
		try {
			encoded = Files.readAllBytes(reader.toPath());
			fileContent = new String(encoded, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileContent;
	}
	
	public void writeJsonFile(JSONObject json,String filePath) {
		try (FileWriter file = new FileWriter(filePath)) {
            file.write(json.toString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
