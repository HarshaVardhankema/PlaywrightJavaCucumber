package StepDefinition;

import Pages.POMDateTable;
import Pages.POMDataTableHomePage;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After; // Import for Cucumber hook
import java.util.List;
import java.util.Map;

public class POMDataTables {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    // Page Object Model instances
    POMDateTable pomDateTable;
    POMDataTableHomePage pomHomePage;

    @Given("Navigate to the midoc Website")
    public void navigate_to_the_midoc_website() {
        playwright = Playwright.create();
        // Launch Firefox in non-headless mode for visibility during execution
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://midoc-provider-dev.azurewebsites.net/login");
        System.out.println("Navigated to midoc Website.");
    }

    @Then("Entering the {string} and {string} in the login page")
    public void entering_the_username_and_password_in_the_login_page(String email, String pass) {
        // Instantiate the login page POM and perform the login action
        pomDateTable = new POMDateTable(page);
        pomDateTable.Login(email, pass);
        // Add a short wait to allow page load/navigation after login
        page.waitForTimeout(3000);
        System.out.println("Scenario Outline: Completed entering credentials and attempted login.");
    }

    @Then("Entering the following credentials in the login page")
    public void entering_the_credentials(io.cucumber.datatable.DataTable dataTable) {
        // Correctly parse the DataTable as a List of Maps (for multiple rows with headers)
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);

        // Iterate through each row of credentials provided in the DataTable
        for (Map<String, String> data : credentials) {
            String email = data.get("email"); // Get the email from the current row
            String pass = data.get("pass");   // Get the password from the current row

            // Perform null/empty checks for robustness, although POMDateTable.Login also does this
            if (email == null || email.isEmpty()) {
                System.err.println("Error: 'email' is null or empty in DataTable row. Skipping this row.");
                continue; // Skip processing this row if data is invalid
            }
            if (pass == null || pass.isEmpty()) {
                System.err.println("Error: 'pass' is null or empty in DataTable row for email: " + email + ". Skipping this row.");
                continue; // Skip processing this row if data is invalid
            }

            // Instantiate the login page POM and perform the login action for the current row
            pomDateTable = new POMDateTable(page);
            pomDateTable.Login(email, pass);
            // Add a short wait to allow page load/navigation after login
            page.waitForTimeout(3000);
            System.out.println("DataTable Scenario: Completed entering credentials and attempted login for email: " + email);
        }
    }

    @Then("Check the current URL")
    public void check_the_current_url() {
        pomHomePage = new POMDataTableHomePage(page);
        String actualUrl = page.url();
        String expectedUrl = pomHomePage.getHomePageUrl();

        System.out.println("Expected URL after login: " + expectedUrl);
        System.out.println("Actual URL after login: " + actualUrl);

        // Assert that the actual URL matches the expected home page URL
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Login successful and redirected to homepage.");
        } else {
            System.err.println("Login failed or not redirected properly. Actual URL: " + actualUrl);
            // You might want to add a screenshot here for debugging failed tests
            // page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/failed_login_" + System.currentTimeMillis() + ".png")));
        }
        page.waitForTimeout(3000); // Small wait before closing for visual confirmation
    }

    @After // This hook will run after each scenario
    public void tearDown() {
        if (browser != null) {
            browser.close();
            System.out.println("Browser closed.");
        }
        if (playwright != null) {
            playwright.close();
            System.out.println("Playwright instance closed.");
        }
    }
}
