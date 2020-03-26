package Sauc_Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Sauc_BaseClasses.Sauc_Utilities;


public class Sauc_Login {

	WebDriver dr;
	Sauc_Utilities sw;
	//Enter the username
	By u=By.xpath("//input[@type='text']");
	//Enter the password
	By p=By.xpath("//input[@type='password']");
	//Click on submit button
	By s=By.xpath("//input[@type='submit']");
	
	public Sauc_Login(WebDriver dr)
	{
		this.dr=dr;
		sw=new Sauc_Utilities(dr);
	}
	
	public void usr(String user)
	{
		dr.findElement(u).sendKeys(user);
	}
	
	public void pwd(String pwd)
	{
		dr.findElement(p).sendKeys(pwd);
	}
	
	public void sub()
	{
		dr.findElement(s).click();
	}
	
	public void Login(String u,String p)
	{
		this.usr(u);
		this.pwd(p);
		this.sub();
	}
}
