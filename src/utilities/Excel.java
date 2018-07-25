package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static String[][] get(String filename) {

		String[][] dataTable = null;
		// create the java file
		File file = new File(filename);
		try {
			// create the excel file
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook xlBook = new XSSFWorkbook(fis);
			XSSFSheet xlSheet = xlBook.getSheetAt(0);

			// Extract the rows and columns
			int rows = xlSheet.getLastRowNum() + 1;
			int cols = xlSheet.getRow(0).getLastCellNum();

			System.out.println("DATASET: " + rows + "x" + cols);
			dataTable = new String[rows][cols];

			// Iterate through excel sheet

			for (int i = 0; i < rows; i++) {

				// create row
				XSSFRow xlRow = xlSheet.getRow(i);
				for (int j = 0; i < cols; j++) {
					System.out.println("Row no: " + i);
					System.out.println("Col no: " + j);
					XSSFCell xlCell = xlRow.getCell(j);
					System.out.println(xlCell.toString());
					dataTable[i][j] = xlCell.toString();
				}
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR: Unable to read workbook");
		}

		return dataTable;
	}

	public static void getXLS() {

	}

}
