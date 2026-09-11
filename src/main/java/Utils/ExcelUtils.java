package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getData(String filePath, String sheetName)
    {
        List<Object[]> rows=new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream))
        {
            Sheet sheet=workbook.getSheet(sheetName);
            if(sheet==null)
            {
                throw new RuntimeException("sheet not found"  +sheetName);

            }
            DataFormatter formatter = new DataFormatter();

            int rowCount=sheet.getPhysicalNumberOfRows();
            int colCount=sheet.getRow(0).getPhysicalNumberOfCells();

            for(int i=1;i<rowCount;i++)
            {
                Row row=sheet.getRow(i);
                if(row==null) continue;



                Object[] rowData=new Object[colCount];

                for(int j=0;j<colCount;j++)
                {
                    Cell cell=row.getCell(j);
                    if (cell==null)
                    {
                        rowData[j]="";
                    }
                    else {
                        rowData[j]=formatter.formatCellValue(cell);
                    }
                }
                rows.add(rowData);
            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rows.toArray(new Object[0][]);
    }
}