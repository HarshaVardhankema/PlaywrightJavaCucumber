package Pages;

import com.microsoft.playwright.Page;

public class POMDataTableHomePage {

    private Page page;

    public POMDataTableHomePage(Page page) {
        this.page = page;
    }

    private String homePageUrl = "https://midoc-provider-dev.azurewebsites.net/home";

    public String getHomePageUrl() {
        return homePageUrl;
    }
}
