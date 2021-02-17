package pageobjects;

import browser.Browser;
import helpers.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BasePage;

public class GoogleSearchPage extends BasePage {
    public static final String PAGE_URL = "https://google.com.ua";

    private static final String GOOGLE_SEARCH_PAGE_LOGO_XPATH = "//img[@alt='Google']";
    private static final String GOOGLE_SEARCH_PAGE_INPUT_FIELD_XPATH = "//input[@role='combobox']";


    @Override
    public boolean verify() {
        return getSearchPageLogo().isDisplayed()
                && getSearchInputField().isDisplayed();
    }

    @Override
    public void waitForPageLoaded() {
        Browser.waiter().waitForElementDisplayed(getSearchPageLogo(), TimeOutConstants.DEFAULT_TIMEOUT_5_000_MS);
    }

    public void open() {
        Browser.getDriver().navigate().to(PAGE_URL);
    }

    public WebElement getSearchPageLogo() {
        return Browser.getDriver().findElement(getLogo());
    }

    public WebElement getSearchInputField() {
        return Browser.getDriver().findElement(getSearchField());
    }

    private By getLogo() {
        return By.xpath(GOOGLE_SEARCH_PAGE_LOGO_XPATH);
    }

    private By getSearchField() {
        return By.xpath(GOOGLE_SEARCH_PAGE_INPUT_FIELD_XPATH);
    }
}
