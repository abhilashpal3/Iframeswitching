package IframeSample.IframeSample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class IframeCheck {

	WebDriver driver;

	WebDriverWait wait;

	@BeforeSuite(alwaysRun = true)
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\RequiredFilesUtility\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println(" Browser Launching");
	}

	@Test(alwaysRun = true, description = "App is Opened in")
	public void OpenApp() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		// To get the total count of iframe
		int size = driver.findElements(By.tagName("iframe")).size();

		System.out.println("No of iframe-" + size);
		driver.switchTo().frame(1);

		System.out.println("Frame successfully switched");
		
		driver.switchTo().parentFrame();
		
		System.out.println("Parent frame found!");
	}

}
