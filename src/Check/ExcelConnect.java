package Check;
 

	 import java.io.File;
	 import java.io.FileInputStream;
	 import org.apache.poi.xssf.usermodel.XSSFSheet;
	 import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	 import org.apache.poi.ss.usermodel.Cell;
	 import org.apache.poi.ss.usermodel.CellType;
	 import org.apache.poi.ss.usermodel.Workbook;
	 import org.apache.poi.ss.usermodel.WorkbookFactory;


	 public class ExcelConnect {
	 	
	 	public static String getCellValue(String path, String Sheet, int r, int c)

	 {

	     try

	           {

	                        FileInputStream fis = new FileInputStream(path);

	                        Workbook wb = WorkbookFactory.create(fis);
	                       
	                        Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);                 
	                       /* if(cell.getCellTypeEnum()==CELL_TYPE_NUMERIC) { 
	                     	   int i = (int)cell.getNumericCellValue();
	                        }*/
	                        //cell.setCellType(Cell.CELL_TYPE_STRING);
	                        CellType type = cell.getCellTypeEnum();
	                        if (type == CellType.NUMERIC) {
	                     	 // double nume= cell.getNumericCellValue();
	                     	  cell.setCellType(CellType.STRING);
	                     	 //return(String.valueOf(nume));
	                     	 // return (nume);
	                        }
	                         return cell.getStringCellValue();

	                           }

	                           catch (Exception e)

	                           {

	                                           return (e.getMessage());

	                           }

	           }

	           public static int getRowCount (String path, String Sheet)

	           {

	               try

	                    {

	                        FileInputStream fis = new FileInputStream(path);

	                        Workbook wb = WorkbookFactory.create(fis);

	                        return wb.getSheet(Sheet).getLastRowNum();

	                           }

	                           catch (Exception e)

	                           {

	                         	  return 0;

	                           }

	           }
	 }


