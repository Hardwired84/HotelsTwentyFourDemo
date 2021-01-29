package pageobjects;

import browser.Browser;
import helpers.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BasePage;

import java.util.List;

public class GoogleSearchResultPage extends BasePage {
    private static final String GOOGLE_SEARCH_RESULT_PAGE_LOGO_XPATH = "//div[@class='logo']";
    private static final String LIST_SEARCHED_RESULTS_XPATH = "//div[@id='rso']//h3";
    private static final String GOOGLE_SEARCH_RESULTS_COUNT_XPATH = "//div[@id='result-stats']";

    @Override
    public boolean verify() {
        return getSearchResultPageLogo().isDisplayed();
    }

    @Override
    public void waitForPageLoaded() {
        Browser.waiter().waitForElementDisplayed(getSearchResultsCount(), TimeOutConstants.DEFAULT_TIMEOUT_10_000_MS);
    }

    public List<WebElement> getSearchResults = Browser.getDriver().findElements(getResultList());

    public WebElement getSearchResultPageLogo() {
        return Browser.getDriver().findElement(getLogo());
    }

    public WebElement getSearchResultsCount() {
        return Browser.getDriver().findElement(getCount());
    }

    private By getResultList() {
        return By.xpath(LIST_SEARCHED_RESULTS_XPATH);
    }

    private By getLogo() {
        return By.xpath(GOOGLE_SEARCH_RESULT_PAGE_LOGO_XPATH);
    }

    private By getCount() {
        return By.xpath(GOOGLE_SEARCH_RESULTS_COUNT_XPATH);
    }
}
