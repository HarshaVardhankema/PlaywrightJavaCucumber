package Pages;

import com.microsoft.playwright.Page;

public class POMDateTable {

    private Page page;

    public POMDateTable(Page page) {
        this.page = page;
    }

    private String loginPageUrl = "https://midoc-provider-dev.azurewebsites.net/login";

    // Ensure these locators are correct for your application's elements
    private String emailusername = "input.chakra-input.css-rlygj7";
    private String password = "input.chakra-input.css-efg1n9";
    private String loginButton = "//button[text()='Continue'].nth(1)";

    public void Login(String email, String pass) {
        // Add robust null/empty checks before using the values
        if (email == null || email.isEmpty()) {
            System.err.println("Error: Email provided to Login method is null or empty.");
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        if (pass == null || pass.isEmpty()) {
            System.err.println("Error: Password provided to Login method is null or empty for email: " + email);
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }

        page.navigate(loginPageUrl); // Navigate to the login page first
        page.fill(emailusername, email); // Fill the email/username field
        page.fill(password, pass);       // Fill the password field
        page.click(loginButton);         // Click the login button
        System.out.println("Performed login attempt for email: " + email);
    }
}
