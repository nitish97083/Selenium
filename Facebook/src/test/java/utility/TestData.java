package utility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestData {

    public static String FName = "Nitish";
    public static String lName = "Verma";
    public static String mNumber = "6290397034";
    public static String mNumberForOTP = "+916290397034";
    public static String password = "Abhi@1234";


    public static String[] fontList = {"casual", "clean", "simple", "fancy", "headline"};
    public static String story = " This is my first post into the Facebook \n Please ignore it  ";

    public static Object[][] readExcel()  {
        Object[][] testData = new Object[0][];
  try {
      File excelFile = new File("C:\\Users\\nitis\\Downloads\\Book 1.xlsx");
      Workbook wb = new XSSFWorkbook(excelFile);

      Sheet sh = wb.getSheetAt(0);

      System.out.println(sh.getLastRowNum());

       testData = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

      int rowNum = 0;
      int cellNum;
      for (Row row : sh) {
          if (row.getRowNum() == 0) continue;
          cellNum = 0;

          for (Cell cell : row) {
              System.out.println("Cell Type  " + rowNum + "     " + cellNum + "    " + cell.getCellType());

              switch (cell.getCellType()) {
                  case NUMERIC: {
//                        System.out.print(cell.getNumericCellValue() + " ");
                      testData[rowNum][cellNum] = cell.getNumericCellValue();
                      break;
                  }
                  case STRING: {
//                        System.out.print(cell.getStringCellValue() + " ");
                      testData[rowNum][cellNum] = cell.getStringCellValue();
                      break;
                  }
                  case BLANK: {
                      System.out.println("Find Blank AT " + rowNum + "     " + cellNum);
                      testData[rowNum][cellNum] = null;
                      break;
                  }
              }
              cellNum++;


          }
          rowNum++;
//            System.out.println("\n");
      }

  }catch (IOException | InvalidFormatException ignored){}


        System.out.println(Arrays.deepToString(testData));
        return testData;
    }



}
