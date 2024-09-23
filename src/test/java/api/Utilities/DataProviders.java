package api.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
 
public class DataProviders {
	
	
	@DataProvider(name="Data")
public String[][] getAllData() throws IOException
{
		
		String path=System.getProperty("user.dir")+"//testData//UserData.xlsx";
		ExcelUtility excel=new ExcelUtility(path);
		
		
		int rownum=excel.getRowCount("ExcelUserData");
		int colcount=excel.getCellCount("ExcelUserData",1);
		
		String apidata[][]=new String[rownum][colcount];

		
		for (int i = 1; i <=rownum; i++)
		{
			
			for (int j = 0; j < colcount; j++)
			{
				
				apidata[i-1][j]=excel.getCellData("ExcelUserData",i,j);				
				
				
			}
		}
		return apidata;
			
}

			@DataProvider(name="UserNames")
			public String [] getUserNames() throws IOException
			{
				String path=System.getProperty("user.dir")+"//testData//UserData.xlsx";
				ExcelUtility excel=new ExcelUtility(path);
				
				
				int rownum=excel.getRowCount("ExcelUserData");
				
				String[] apidata=new String [rownum];

				
				for (int i = 1; i <=rownum; i++)
				{
					
						
						apidata[i-1]=excel.getCellData("ExcelUserData",i,1);				
						
						
					
				}
				return apidata;
			
		}
		
	
}


