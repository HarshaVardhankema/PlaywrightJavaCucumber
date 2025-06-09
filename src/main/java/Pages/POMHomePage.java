package Pages;

import com.microsoft.playwright.Page;

public class POMHomePage {


    private Page page;

    public POMHomePage(Page page) {
        this.page = page;
    }

    private String homePageUrl = "https://midoc-provider-dev.azurewebsites.net/home";

    public String getHomePageUrl() {
        return homePageUrl;
    }
}
