package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public List<Map<String, String>> getData(String excelPath, String sheetName) {
		List<Map<String, String>> dataList = new ArrayList<>();
		DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(new File(excelPath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
				throw new RuntimeException("Sheet with name '" + sheetName + "' not found in the workbook.");
            }

            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);

				// Skips to the next iteration if the row is blank or null
				if (currentRow == null || formatter.formatCellValue(currentRow.getCell(0)).trim().isEmpty()) {
					continue;
				}

				Map<String, String> rowMap = new HashMap<>();

				for (int j = 0; j < headerRow.getLastCellNum(); j++) {
					String header = formatter.formatCellValue(headerRow.getCell(j));
					String value = formatter.formatCellValue(currentRow.getCell(j));
					rowMap.put(header, value);
                }
				dataList.add(rowMap);
            }

        } catch (IOException e) {
			e.printStackTrace();
        }

		return dataList;
    }
}