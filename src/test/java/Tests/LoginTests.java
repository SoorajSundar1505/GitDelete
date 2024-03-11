package Tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;

import Pages.LoginPage;
import Utils.InitDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Regression Test Suite")
@Feature("Login to Orange HRM application")
public class LoginTests extends InitDriver {
	LoginPage login;
	SoftAssert softassert = new SoftAssert();
	@BeforeSuite
	public void Setup() {
		SetUp_Browser_Driver();
		login = new LoginPage();
	}

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Login to OrangeHRM")
	@Story("Login page functionality")
	public void LoginToOrangeHRMValid() throws IOException {
		login.logintoApp("validUsername", "validPassword");
//		takeScreenshot();
		}

	@Test
	@Severity(SeverityLevel.MINOR)
	@Description("Login to OrangeHRM")
	@Story("Login page functionality")
	public void LoginToOrangeHRMInValid() throws IOException {
		login.logintoApp("invalidUsername", "invalidPassword");
		String expected = driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
		softassert.assertEquals("Invalid", expected);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		softassert.assertAll();
//		takeScreenshot();
		}

	@AfterSuite
	public void Teardown() {
		TearDown();
	}
	
	@AfterMethod
	public void sc(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			File path = takeScreenshot();
			Allure.addAttachment("Page Screenshot", FileUtils.openInputStream(path));		
		}
	}

}
