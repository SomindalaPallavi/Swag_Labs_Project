package Sauc_Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Sauc_BaseClasses.Sauc_Utilities;


public class Sauc_Cart {
	
	WebDriver dr;
	Sauc_Utilities sw;
	//To select the product
	By pro=By.xpath("//select[@class='product_sort_container']/option[1]");
	//Click on add to cart button
	By ac=By.xpath("//button[text()='ADD TO CART']");
	
	By cb=By.xpath("//div[@class='bm-burger-button']");

	public Sauc_Cart(WebDriver dr)
	{
		this.dr=dr;
		sw=new Sauc_Utilities(dr);
	}
	
	public void product()
	{
		dr.findElement(pro).click();
	}
	
	public void add()
	{
		dr.findElement(ac).click();
	}
	
	public void but()
	{
		dr.findElement(cb).click();
	}
	
	public void Add_to_Cart()
	{
		this.product();
		this.add();
		this.but();
	}
}

