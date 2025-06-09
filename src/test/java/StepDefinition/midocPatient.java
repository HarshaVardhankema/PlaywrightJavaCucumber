package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

public class midocPatient {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Given("^I am on the login page$")
    public void I_am_on_the_login_page() throws InterruptedException {
        driver.get("https://midoc-patientapp-dev.azurewebsites.net/login");
        Thread.sleep(3000);

    }

    @When("^I enter valid credentials$")
    public void I_enter_valid_credentials() throws InterruptedException {
        driver.findElement(By.cssSelector("input.chakra-input.css-dhzvz6"))
                .sendKeys("vegas@gmail.com", Keys.ENTER);
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input.chakra-input.css-1rsaweq"))
                .sendKeys("midoc123", Keys.ENTER);
        Thread.sleep(3000);
    }

    @Then("^I should be redirected to the patient dashboard$")
    public void I_should_be_redirected_to_the_patient_dashboard() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue("User is not redirected to home", currentUrl.contains("home"));
        driver.quit();
    }
}
