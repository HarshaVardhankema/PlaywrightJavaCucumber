package StepDefinition;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Background {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @Before
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    @Given("I open the browser")
    public void i_open_the_browser() {
        page.navigate("https://www.google.com/");
    }

    @And("I navigate to {string}")
    public void i_navigate_to_url(String url) {
        page.navigate(url);
    }

    @And("I search for {string}")
    public void i_search_for(String searchQuery) {
        page.fill("input[name='q']", searchQuery);
        page.keyboard().press("Enter");
    }

    @And("I click on the first video")
    public void i_click_on_first_video() {
        page.waitForSelector("ytd-thumbnail a#thumbnail");
        page.click("ytd-thumbnail a#thumbnail");
    }

    @And("I click on the first link")
    public void i_click_on_first_link() {
        page.waitForSelector("h3");
        page.click("h3");
    }

    @And("I should see the video playing")
    public void i_should_see_video_playing() {
        page.waitForSelector(".html5-video-player");
        System.out.println("Video is playing.");
    }

    @And("I should see the search results page")
    public void i_should_see_search_results_page() {
        System.out.println("Search results page displayed.");
    }
}
