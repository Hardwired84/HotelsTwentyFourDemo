package stepdefs;

import cucumber.api.java.en.Given;
import pageobjects.GoogleSearchPage;

public class GoogleSearchStepDefs {
    private static final GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("^I search \"([^\"]*)\"$")
    public void i_search(String searchedText) {
        googleSearchPage.getSearchInputField().sendKeys(searchedText);
        googleSearchPage.getSearchInputField().submit();
    }

    @Given("^I open Google Search page$")
    public void iOpenGoogleSearchPage() {
        googleSearchPage.open();
        googleSearchPage.waitForPageLoaded();
    }
}
