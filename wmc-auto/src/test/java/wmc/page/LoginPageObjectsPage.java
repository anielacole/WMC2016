package wmc.page;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPageObjectsPage {

	WebDriver driver;

	WebElement fieldLogin;

	WebElement fieldPassword;

	WebElement buttonEnviar;

	public void startFirefox() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void openTheAplication(String url) {
		driver.get(url);
	}

	public void putTheUserName(String user) {
		fieldLogin = driver.findElement(By.name("login"));
		fieldLogin.sendKeys(user);
	}

	public void putThePassword(String password) {
		fieldPassword = driver.findElement(By.name("senha"));
		fieldPassword.sendKeys(password);
	}

	public void clickInTheButtonEnviar() {
		buttonEnviar = driver.findElement(By.name("submit"));
		buttonEnviar.click();
	}

	public void validateTheHomePage() {
		String xpathButtonNovaMensagem = "/html/body/table/tbody/tr[5]/td/table/tbody/tr/td/a[1]/img";
		Assert.assertTrue(driver.findElement(By.xpath(xpathButtonNovaMensagem)).isDisplayed());
	}

	public void closeDriver() {
		driver.close();
	}

}
