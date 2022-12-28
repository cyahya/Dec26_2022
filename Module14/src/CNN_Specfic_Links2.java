import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CNN_Specfic_Links2 {
	static WebDriver driver ;
	public static void main(String[] args) {
		//getResponseCode("http://soapuitutorial.com");
		
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");

		 driver = new FirefoxDriver();
		// implicit wait -  dynamic wait
		// applicable to all driver.findElement commands
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("http://cnn.com");
		driver.navigate().to("http://cnn.com");// remember browser history
		String part1="//*[@id='intl_homepage1-zone-1']/div[2]/div/div[3]/ul/li[";
		String part2="]/article/div/div/h3/a";
		//isElementPresent("//a[@id='xyz']","xpath");
		//for(int i=2;i<=9;i++){
		
		int i=2;
		while(isElementPresent(part1+i+part2, "xpath")){
			String text = driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(text);
			// get response code
			String url=driver.findElement(By.xpath(part1+i+part2)).getAttribute("href");
			if(getResponseCode(url)){
				driver.findElement(By.xpath(part1+i+part2)).click();
				// response code
				System.out.println(driver.getTitle());
				driver.navigate().back();// back button
			}else{
				// report a failure
			}
			i++;
		}
	
	}
	// true - present
	// false - not present
	public static boolean isElementPresent(String locator, String locatorType){
		List<WebElement> allElements=null;
			if(locatorType.equals("xpath"))
				allElements = driver.findElements(By.xpath(locator));
			else if(locatorType.equals("cssSelector"))
				allElements = driver.findElements(By.cssSelector(locator));
			else if(locatorType.equals("id"))
				allElements = driver.findElements(By.id(locator));
			else if(locatorType.equals("name"))
				allElements = driver.findElements(By.name(locator));
			
			if(allElements.size()==0)
				return false;
			else
				return true;
	}
	
	public static boolean getResponseCode(String url){
		int resp_code=0;
		try {
			resp_code = Request.Get(url).execute().returnResponse().getStatusLine()
			        .getStatusCode();
	        System.out.println("Respose code for URL "+ url +" is -> "+ resp_code);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(resp_code==200)
        	return true;
        else 
        	return false;
	}


}
