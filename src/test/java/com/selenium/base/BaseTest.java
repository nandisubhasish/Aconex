package com.selenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;


public class BaseTest {
	public WebDriver driver;
	public Properties properties;
	
	public void openBrowser(String bType) {
		
		
		//Initialize the properties file
		if(properties==null)
			properties=new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\projectconfig.properties");
			properties.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(bType.equals("Mozzila"))
			driver=new FirefoxDriver();
		if(bType.equals("Chrome"))
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromedriver_exe"));
		
		driver=new ChromeDriver();	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public void navigate(String url) {
		driver.get( properties.getProperty(url));
		
	}
	
	public void clickItem(String xpathOfElement) {
		driver.findElement(By.xpath(properties.getProperty(xpathOfElement))).click();
				
	}
	
	public void typeInto(String xpathOfElement,String valueOfElement) {
		driver.findElement(By.xpath(properties.getProperty(xpathOfElement))).sendKeys(properties.getProperty(valueOfElement));;
		
	}
	
	public void typeInto(String xpathOfElement,String valueOfElement,String notRequired) {
		driver.findElement(By.xpath(properties.getProperty(xpathOfElement))).sendKeys(valueOfElement);;
		
	}
	
	/**
	 * Wait for the page to load based on Loading text.
	 */
	public void waitForPageToLoad() {
		List<WebElement> elements;

		try {
			int cnt = 0;
			elements = driver.findElements(By.xpath(properties.getProperty("xpath_Page_Load_Id")));

			while (!elements.isEmpty() && cnt++ < 60) {
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				elements = driver.findElements(By.xpath(properties.getProperty("xpath_Page_Load_Id")));
			}
		} catch (Exception e) {
		}
	}
	
	public void waitForElement(String xpathOfElement) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty(xpathOfElement))));
	}
	
	public void selectDropDown(String xpathOfDropDown,String value_In_DropDown) {
		Select value=new Select(driver.findElement(By.xpath(properties.getProperty(xpathOfDropDown))));
		value.selectByVisibleText(properties.getProperty(value_In_DropDown));
	}
	
	public void switchFrame(int frameIndex) {

		//switch to first frame
		driver.switchTo().frame(frameIndex);
	}
	
	public void frameCount() {
		
		//Find total number of FRAMES present on page.
		
		int total = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total number of FRAME presnt on page are --- "+total);
	}
	
	public void managingFrames(String xpathOfElement) {
		
		int total = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total number of FRAME presnt on page are --- "+total);
		
			for (int i=0;i<total;i++){
				driver.switchTo().frame(i);
				int s=driver.findElements(By.xpath(properties.getProperty(xpathOfElement))).size();
				System.out.println("Size = "+s);				
				if (s==0)
					driver.switchTo().defaultContent();
				else
					break;
			}
			
	}
	
	public void switchFrameToDefault() {
		
		driver.switchTo().defaultContent();
		
	}
	
	/******************************Validation********************************************/
	public boolean verifyMailSent() {
		
		return false;
	}
	
	public boolean veriftText(String xpathOfMailNumber) {
		
		String mailNumber = driver.findElement(By.xpath(properties.getProperty(xpathOfMailNumber))).getText();
		if(mailNumber!=null)
		return true;
		else 
			return false;
	}
	
	/*********************Reporting********************************************************/
	
	public void reportPass(String msg) {
		
	}
	
    public void reportFail(String msg) {
		
	}
    
    public String GetDate() {
    	 

    	 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    	 Date date = new Date();
    	 String date1= dateFormat.format(date);
    	 
    	 return date1;
    	 
    	 }
    
    public void uploadWindowsDialog(String fileAddressToUpload) throws SikuliException {
    	
    	Pattern p1 = new Pattern(System.getProperty("user.dir")+"\\src\\test\\resources\\PP1.png");
		Pattern p2 = new Pattern(System.getProperty("user.dir")+"\\src\\test\\resources\\PP2.png");
		Screen s=new Screen();

		s.type(p1,properties.getProperty(fileAddressToUpload));
		s.click(p2);
    }
    
    public void findElement(String xpathOfWebElement) {
       
            List<WebElement> elements = driver.findElements(By.xpath(properties.getProperty(xpathOfWebElement)));
            for (WebElement element : elements){

                if (element.getText().contains("AGD")) {
                    System.out.println(element);
                }
    }}
}
