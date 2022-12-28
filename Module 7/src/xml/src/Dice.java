package xml.src;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Dice {
	WebDriver driver;
	
	@Test
	public void searchJobs() throws InterruptedException{
		System.out.println("This is AT code-------");
		String tool="Selenium WebDriver";// watch module 7 and pass tool and location from xls+ testng dataprovider
		String location="New York, NY";
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hossa\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	    driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.dice.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(3000);
		selectValue(tool);
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys("New York");
		Thread.sleep(3000);
		selectValue(location);
		driver.findElement(By.xpath("//button[@id='findTechJobs']")).click();
		waitForPageToLoad();
		Thread.sleep(3000);
		
		
		
		int i=1;
		List<WebElement> pageLinks = driver.findElements(By.xpath("//div[@id='dice_paging_top']/ul/li/a"));
		int j = pageLinks.size()-2;
		System.out.println("###################total page = "+j);
		
		while(i<=j){
		System.out.println("------------Page Number "+ i);	
		
			//List<WebElement> jobLinks = driver.findElements(By.xpath("//span[@itemprop='title']"));
			List<WebElement> jobLinks = driver.findElements(By.xpath("//a[@class='dice-btn-link loggedInVisited easy-apply']"));
			for(WebElement e:jobLinks){
				if(!e.getText().trim().equals(""))
					System.out.println("Job Title: "+e.getText());
			}
			i++;
			if(i==6)
				break;
			
			driver.findElement(By.xpath("//a[text()='"+i+"']")).click();
		}
	}
	
	public void selectValue(String selection){
		
		if (selection.equals("Selenium WebDriver")){
			List<WebElement> options = driver.findElements(By.xpath("//ul[@class='typeahead__list']/li"));
			System.out.println("Total options - "+options.size());
			for(WebElement e:options){
				System.out.println(e.getText());
				if(e.getText().equals(selection)){
					Actions act = new Actions(driver);
					act.click(e).build().perform();
					break;
				}
			}
		}else{
			List<WebElement> options = driver.findElements(By.xpath("//ul[@class='typeahead dropdown-menu']/li"));
			System.out.println("Total options - "+options.size());
			for(WebElement e:options){
				System.out.println(e.getText());
				if(e.getText().equals(selection)){
					Actions act = new Actions(driver);
					act.click(e).build().perform();
					break;
				}
			}
		}
		
		//List<WebElement> options = driver.findElements(By.xpath("//ul[@class='typeahead__list']/li"));
		
	
	}
	
	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int i=0;
		
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		//System.out.println(state);

		if(state.equals("complete"))
			break;
		else
			wait(4);

		i++;
		}
		wait(2);// wait of 2 sec between page status and jquery
		// check for jquery status
		i=0;
		while(i!=10){
	
			Boolean result= (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
			//System.out.println(result);
			if(result )
			 	break;
			else
				 wait(2);
			 i++;
				
			}
		
		}
	

	public void wait(int time){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
