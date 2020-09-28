package com.scale.bat.framework.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class CSVUtils {
	private Logger log = Log.getLogger(CSVUtils.class);
	private String filePath;

	public CSVUtils(String filePath) {
		this.filePath = filePath;
	}

	/*
	 * This method is used for product creation. Data with isUsed value as 0 will be
	 * picked to create the new product in product creation script. Once the data is
	 * picked, isUsed value will be changed to 1.
	 */
	public Map<String, String> readCsvAsMap(boolean writeCsv) throws FileNotFoundException, IOException, CsvException {
		String[] content;
		String[] headers = readCsvHeader();
		Map<String, String> map = new LinkedHashMap<String, String>();
		int lineNumber = 0;
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			while ((content = reader.readNext()) != null) {
				lineNumber++;
				if (content[content.length - 1].equalsIgnoreCase("0")) {
					for (int i = 0; i < content.length - 1; i++) {
						map.put(headers[i], content[i]);
					}
					map.put("isUsed", "1");
					break;
				}
			}
		}
		List<String[]> csvBody = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			csvBody = reader.readAll();
		}
		if (writeCsv) {
			log.info(map);
			updateCSVForSpecificLine(lineNumber, csvBody, map.values().toArray(new String[0]));
		}
		return map;
	}

	private String[] readCsvHeader() throws FileNotFoundException, IOException, CsvValidationException {
		String[] content;
		try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
			content = reader.readNext();
		}
		return content;
	}
	
/*
 * First line starts as 1
 */
	private void updateCSVForSpecificLine(int linNumber, List<String[]> csvBody, String[] lineToReplace)
			throws IOException {
		try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
			csvBody.set(linNumber - 1, lineToReplace);
			writer.writeAll(csvBody);
		}
	}
}
