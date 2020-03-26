package Sauc_BaseClasses;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sauc_Utilities {

	WebDriver dr;
	static int counter =0;
	
	public Sauc_Utilities(WebDriver dr)
	{
		this.dr=dr;
	}
	
	public WebDriver Launch_Browser(String browser,String url) {
		
		if(browser.contains("chrome")) {
			//To launch the chrome browser
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");
			dr=new ChromeDriver();
			
		}
		else if(browser.contains("firefox")) {
			//To launch the firefox browser
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Driver\\geckodriver.exe");
			dr=new FirefoxDriver();
		}
		
		dr.get(url);
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return dr;
		
	}
	
	public WebElement waitForElement(By locator,int timeout)
	{
		 try {
			   	WebDriverWait wait=new WebDriverWait(dr,timeout);
				WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				return element;
			   }
			   catch(Exception e) {
				   System.out.println("Element not located" +e);
			   }
			return null;
	}	
			
			
			
	public WebElement elementToBeClickable(By locator,int timeout) 
	{
		try {
				WebDriverWait wait=new WebDriverWait(dr,timeout);
				WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
				return element;
				} catch(Exception e) {
					   System.out.println("Element not located" +e);
				}
				return null;
				
	}
	//To take the Screenshot
	public void ScreenShot()
	{
		String	path="src\\test\\resources\\Screenshot\\";
		String FileName=counter+".png";

		File f1 = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		File f2 = new File(path+FileName);
		try {
			FileUtils.copyFile(f1, f2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
				
		counter++;
	}

	
	
}
