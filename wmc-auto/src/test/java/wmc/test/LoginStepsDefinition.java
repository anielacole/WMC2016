package wmc.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepsDefinition {

	WebDriver driver;

	WebElement fieldLogin;

	WebElement fieldPassword;

	WebElement buttonEnviar;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Given(value = "^I open the aplication$")
	public void openedTheAplication() throws InterruptedException {
		driver.get("http://wmc2016tts.somee.com/index.asp");
		Thread.sleep(5000);
	}

	@When(value = "^I put the user \"([^\"]*)\"$")
	public void putTheUser(String user) {
		fieldLogin = driver.findElement(By.name("login"));
		fieldLogin.sendKeys(user);
	}

	@When(value = "^I put the password \"([^\"]*)\"$")
	public void putThePassword(String password) {
		fieldPassword = driver.findElement(By.name("senha"));
		fieldPassword.sendKeys(password);
	}

	@When(value = "^I click in the button Enviar$")
	public void clickInTheButton() {
		buttonEnviar = driver.findElement(By.name("submit"));
		buttonEnviar.click();
	}

	@Then(value = "^I validate the home page$")
	public void validateTheHomePage() {
		String xpathButtonNovaMensagem = "/html/body/table/tbody/tr[5]/td/table/tbody/tr/td/a[1]/img";
		Assert.assertTrue(driver.findElement(By.xpath(xpathButtonNovaMensagem)).isDisplayed());
	}

	@After
	public void closeBrowser() {
		driver.close();
	}
}
