package scripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScripts 
{
	WebDriver driver;
	
	//Here only LoginVerify method will run multiple time untill it PASS
	//Maximum it will runs for 3 times
	//@Test(retryAnalyzer = retryAnalyser.RetryAnalyser.class)
	@Test
	public void LoginVerify()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		String loginTItle = driver.getTitle();
		boolean blt = loginTItle.contains("viger");
		Assert.assertTrue(blt);
	}
	
	//For this Test Script we have not defined "retryAnalyzer"
	//It will only run for 1 time
	@Test
	public void homeVerify()
	{
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		String HomeTitle = driver.getTitle();
		boolean ht = HomeTitle.contains("vtiger");
		Assert.assertTrue(ht);
	}
}
