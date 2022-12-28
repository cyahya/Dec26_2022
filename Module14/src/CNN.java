import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CNN {

	public static void main(String[] args) throws InterruptedException {
		// options
		WebDriver driver = new FirefoxDriver();
		// implicit wait -  dynamic wait
		// applicable to all driver.findElement commands
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://cnn.com");
		
		// wait
		//Thread.sleep(10000);// pausing for 10 sec 
		
		
		// waits dynamically till 20 secs
		String text = driver.findElement(By.xpath("//*[@id='intl_homepage1-zone-1XXX']/div[2]/div/div[1]/ul/li[1]/article/a/h2")).getText();
		System.out.println(text);
	}

}
