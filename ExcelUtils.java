package Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static FileInputStream fi;
	private static FileOutputStream fo;
	private static Workbook classeur;
	private static Sheet feuille;
	private static Row row;
	private static Cell cell;

	public static void setExcelFile(String xlfile, String xlsheet) throws Exception {

		try {

			fi = new FileInputStream(xlfile);
			classeur = new XSSFWorkbook(fi);
			feuille = classeur.getSheet(xlsheet);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowCount() throws Exception {

		int rowcount = feuille.getLastRowNum();
//		classeur.close();
//		fi.close();
		return rowcount;
	}

	public static int getCellCount() throws Exception {
		row = feuille.getRow(0);
		int cellcount = row.getLastCellNum();
//		classeur.close();
//		fi.close();
		return cellcount;
	}

	public static String getCellData(int rownum, int colnum) throws Exception {
		// ExcelUtils.setExcelFile(xlfile, xlsheet);
		row = feuille.getRow(rownum);
		cell = row.getCell(colnum);
		DataFormatter formatter = new DataFormatter();
		String data;
		data = formatter.formatCellValue(cell);
//		classeur.close();
//		fi.close();
		return data;
	}

	public static void setCellData(int rownum, int colnum, String data) throws Exception {
		row = feuille.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);

	}

	public static void SaveAs(String xlfile) throws Exception {
		fo = new FileOutputStream(xlfile);
		classeur.write(fo);
		classeur.close();
		fi.close();
		fo.close();
	}
}