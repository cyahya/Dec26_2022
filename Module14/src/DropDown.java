import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDown {

	public static void main(String[] args) {
		// select
		// count total
		// print all
		// find which is selected
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://qtpselenium.com/home/contact_trainer");
		
		WebElement dropDown = driver.findElement(By.name("country_id"));
		Select s = new Select(dropDown);
		
		// select
		//s.selectByIndex(3);
		s.selectByVisibleText("Belgium");
		//s.selectByValue("10");
		
		List<WebElement> options = s.getOptions();
		
		System.out.println("Total elements "+options.size());
		for(WebElement e:options){
			System.out.println(e.getText());
		}
		
		System.out.println("Currently -" +s.getFirstSelectedOption().getText());
		

	}

}
