package StepDefinition;

import Pages.POMExamples;
import Pages.POMHomePage;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class POMNegative {

         private Playwright playwright;
        private Browser browser;
        private BrowserContext context;
        private Page page;

        POMHomePage pomHomePage;
        POMExamples pomExamples;

        @Given("Opening the application")
        public void opening_the_application() {
            playwright = Playwright.create();
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            context = browser.newContext();
            page = context.newPage();
            page.navigate("https://midoc-provider-dev.azurewebsites.net/login");
        }

        @Then("Login with valid details")
        public void login_with_valid_credentials() {
            pomExamples = new POMExamples(page);
            pomExamples.Login("zampa@gmail.com", "midoc123");
            page.waitForTimeout(5000);
        }

        @Then("I should be redirected to the doctor home pages")
        public void i_should_be_redirected_to_the_doctor_home_page() {
            pomHomePage = new POMHomePage(page);
            String currentUrl = page.url();
            page.waitForTimeout(5000);


        }
    }


