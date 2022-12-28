import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AllLinks {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		WebDriver driver = new FirefoxDriver();
		// implicit wait -  dynamic wait
		// applicable to all driver.findElement commands
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://cnn.com");
		// all links
		//driver.findElements(By.xpath("//a"));
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links - "+ links.size());
		
		WebElement tenthLink = links.get(9);
		System.out.println(tenthLink.getText());
		System.out.println(tenthLink.getLocation().x);
		System.out.println(tenthLink.getLocation().y);
		//tenthLink.click();
		/*
		for(int i=0;i<links.size();i++){
			WebElement link = links.get(i);
			System.out.println(link.getText()+" --- "+link.isDisplayed());
		}

		 */
		
		for(WebElement e:links){
			System.out.println(e.getText()+" --- "+e.isDisplayed());
		}

	}

}
