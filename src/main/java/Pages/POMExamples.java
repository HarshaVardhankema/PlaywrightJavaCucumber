package Pages;

import com.microsoft.playwright.Page;

public class POMExamples {

    private Page page;

    public POMExamples(Page page) {
        this.page = page;
    }

    private String loginPageUrl = "https://midoc-provider-dev.azurewebsites.net/login";

    private String emailusername = "input.chakra-input.css-rlygj7";

    private String password = "input.chakra-input.css-efg1n9";

    private String loginButton = "//button[text()='Continue']";


    public void Login(String email, String pass) {
        page.navigate(loginPageUrl);
        page.fill(emailusername, "zampa@gmail.com");
        page.fill(password, "midoc123");
        page.click(loginButton);
    }
}
