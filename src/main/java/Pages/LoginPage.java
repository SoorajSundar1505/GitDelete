package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Helper;
import Utils.InitDriver;

public class LoginPage extends InitDriver{

	@FindBy(name="username")
	private WebElement usernameInput;
	
	@FindBy(name="password")
	private WebElement passwordInput;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	Helper help = new Helper();
	
	public void logintoApp(String uname, String pwd) throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		usernameInput.sendKeys(help.readDataFile(uname));
		passwordInput.sendKeys(help.readDataFile(pwd));
		submitBtn.click();
		
	}
}
