package Sauc_Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Sauc_BaseClasses.Sauc_Utilities;


public class Sauc_About {

	WebDriver dr;
	Sauc_Utilities sw;
	//Click on about
	By ab=By.xpath("//a[text()='About']");

	By fi=By.xpath("//a[@class='button is-rounded is-primary'][contains(text(),'Learn more')]");
	
	public Sauc_About(WebDriver dr)
	{
		this.dr=dr;
		sw=new Sauc_Utilities(dr);
	}
	
	public void abo()
	{
		dr.findElement(ab).click();
	}
	
	public void field()
	{
		dr.findElement(fi).click();
	}
	
	public void Sel_Field()
	{
		this.abo();
		this.field();
	}	
}
