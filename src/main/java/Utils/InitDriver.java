package Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;

public class InitDriver {
	public static WebDriver driver;
	
	
	public void SetUp_Browser_Driver() {
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	public void TearDown() {
		driver.quit();
	}
	
	public File takeScreenshot() throws IOException {
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
        File src = takescreenshot.getScreenshotAs(OutputType.FILE);
        // Define the destination path for the screenshot
        String screenshotPath = System.getProperty("user.dir") + File.separator + "Screenshot" + File.separator + "screenshot.png";

        // Copy the screenshot to the destination path
        FileUtils.copyFile(src, new File(screenshotPath));
        
        // Return the File object representing the screenshot
        return src;
	}
}