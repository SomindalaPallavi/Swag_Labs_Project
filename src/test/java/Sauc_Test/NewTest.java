package Sauc_Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Excel_utilities.Get_Excel;
import Sauc_BaseClasses.Sauc_Utilities;
import Sauc_Pom.Sauc_About;
import Sauc_Pom.Sauc_Cart;
import Sauc_Pom.Sauc_Login;

public class NewTest extends Get_Excel{
	

	Sauc_Utilities sw;
	
	WebDriver dr;
	
	String url="https://www.saucedemo.com/"; 
	
	Sauc_Login sl;
	Sauc_Cart sc;
	Sauc_About sa;
	
	@BeforeClass
	public void getdata()
	{
		sw=new Sauc_Utilities(dr);
		//To get the data from excel
		get_Excel();
	}
	
	@BeforeMethod
	public void bm()
	{
		
		sw=new Sauc_Utilities(dr);
		//To launch the website
		dr=sw.Launch_Browser("chrome", url);
	}
	
	@Test(dataProvider="login_data")
	public void test1(String u,String p)
	{
		sl=new Sauc_Login(dr);
		sl.Login(u, p);
		
		sc=new Sauc_Cart(dr);																									
		sc.Add_to_Cart();
		
		sa=new Sauc_About(dr);
		sa.Sel_Field();
		
		sw.ScreenShot();
		
	}

	@DataProvider(name="login_data")
	public String[][] provide_data()
	{
		return testdata;
		
	}
}
