import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Radios {
	static WebDriver driver;
	
	public static void main(String[] args) {
	    driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://tutorialehtml.com/en/html-tutorial-radio-buttons/");
		
		List<WebElement> allRadios = driver.findElements(By.name("citizenship"));
		System.out.println("Total radio buttons "+allRadios.size() );
		allRadios.get(0).click();
		System.out.println(allRadios.get(0).getAttribute("selected"));
		System.out.println(allRadios.get(1).getAttribute("selected"));
		System.out.println(allRadios.get(2).getAttribute("selected"));
		takeScreenShot();
	}
	
	public static void takeScreenShot(){
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"//radio.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
