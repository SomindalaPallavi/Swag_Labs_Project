package Sauc_Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Excel_utilities.Get_Excel;
import Sauc_BaseClasses.Sauc_Utilities;
import Sauc_Pom.Sauc_About;
import Sauc_Pom.Sauc_Cart;
import Sauc_Pom.Sauc_Login;

public class NewTest1 extends Get_Excel{
	

	Sauc_Utilities sw;
	
	WebDriver dr;
	
	String url="https://www.saucedemo.com/"; 
	
	Sauc_Login sl;
	Sauc_Cart sc;
	Sauc_About sa;
	String expectedError="Epic sadface: Username and password do not match any user in this service";
	String expectedtitle="Swag Labs";
	String expectedname="Sauce Labs Backpack";
	
	@BeforeClass
	public void getdata()
	{
		
		get_Excel();
		
	}
	
	@BeforeMethod
	public void launch_Browser()
	{
		sw=new Sauc_Utilities(dr);
		
		dr=sw.Launch_Browser("chrome", url);
		String title=dr.getTitle();
		Assert.assertEquals(title, expectedtitle);
		
	}
	
	
	@Test(priority=0)
	public void test1()
	{
		
		String username=testdata[0][0];
		String password=testdata[0][1];
		sl=new Sauc_Login(dr);
		sl.Login(username, password);
		
		sw.ScreenShot();
		
	}
	@Test(priority=1)
	public void test2()
	{
		
		String username=testdata[1][0];
		String password=testdata[1][1];
		sl=new Sauc_Login(dr);
		sl.Login(username, password);
		
		sc=new Sauc_Cart(dr);																									
		sc.Add_to_Cart();
		String productname=sc.productname1;
		Assert.assertEquals(productname, expectedname);    // verifying the name of added item to the cart
		
		sa=new Sauc_About(dr);
		sa.Sel_Field();
		
		sw.ScreenShot();
		
	}
	
	
	@Test(priority=3)
	public void test3()
	{
		
		String username=testdata[2][0];
		String password=testdata[2][1];
		sl=new Sauc_Login(dr);
		sl.Login(username, password);
		sw.ScreenShot();
		String Error=dr.findElement(By.xpath("//h3[@data-test='error'] ")).getText();
		Assert.assertEquals(Error, expectedError);
		
		
	}
	
	
}
