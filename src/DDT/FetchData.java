package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchData {
	
	
	
	public static ArrayList<Object[]> login() throws Exception
	{
		ArrayList<Object[]> al=new ArrayList<Object[]>();
		File f=new File("C:\\Users\\stephen\\Desktop\\Testdata.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s1=wb.getSheetAt(0);
		int n=s1.getLastRowNum();
		
		for(int i=1;i<+n;i++)
		{
			String un=s1.getRow(i).getCell(0).getStringCellValue().toString();
			System.out.print("  "+un+" ");
			String pass=s1.getRow(i).getCell(1).getStringCellValue().toString();
			System.out.print("   "+pass+" ");
			String city=s1.getRow(i).getCell(2).getStringCellValue().toString();
			System.out.print("   "+city+" ");
			String pin=s1.getRow(i).getCell(3).getStringCellValue().toString();
			System.out.print("   "+pin+" ");
			String area=s1.getRow(i).getCell(4).getStringCellValue().toString();
			System.out.print("   "+area+" ");
			String country=s1.getRow(i).getCell(5).getStringCellValue().toString();
			System.out.print("   "+country+" ");
			System.out.println("");
			
			Object[] o= new Object[]{un,pass,city,pin,area,country};
			al.add(o);
			
		}
		wb.close();
		System.out.println(al.size());
		return al;
		
		
	}

}
