package PatseerQueries;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FetchData {
	
	@Test
	public ArrayList<Object[]> fetch() throws Exception
	{
		File f=new File("E:\\Automation_softwares _and_jar_files\\Files\\NewQueries.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s1=wb.getSheetAt(0);
		ArrayList<Object[]> al=new ArrayList<Object[]>();
		int n=s1.getLastRowNum();
		for(int i=1;i<=n;i++)
		{
		String Query=s1.getRow(i).getCell(0).getStringCellValue().toString();
		
		Object[] o=new Object[]{Query};
		al.add(o);
		System.out.println("fetching***************************************************************");
		
		}	
		System.out.println("data is fetched");
		wb.close();
		return al;
	}
	
	

}
