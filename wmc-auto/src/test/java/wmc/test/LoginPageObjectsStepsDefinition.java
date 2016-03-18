package wmc.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wmc.page.LoginPageObjectsPage;

public class LoginPageObjectsStepsDefinition {

	LoginPageObjectsPage loginPageObjectsPage = new LoginPageObjectsPage();

	@Before
	public void setup() {
		loginPageObjectsPage.startFirefox();
	}

	@Given(value = "^I open the aplication url PG$")
	public void openTheAplication() {
		loginPageObjectsPage.openTheAplication("http://wmc2016tts.somee.com/index.asp");
	}

	@When(value = "^I put the user \"([^\"]*)\" PG$")
	public void putTheUser(String user) {
		loginPageObjectsPage.putTheUserName(user);
	}

	@When(value = "^I put the password \"([^\"]*)\" PG$")
	public void putThePassword(String password) {
		loginPageObjectsPage.putThePassword(password);
	}

	@When(value = "^I click in the button Enviar PG$")
	public void clickInTheButtonEnviar() {
		loginPageObjectsPage.clickInTheButtonEnviar();
	}

	@Then(value = "^I validate the home page PG$")
	public void validateTheHomePage() {
		loginPageObjectsPage.validateTheHomePage();
	}

	@After
	public void closeBrowser() {
		loginPageObjectsPage.closeDriver();
	}
}
