package stepdefs;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import pageobjects.GoogleSearchResultPage;

public class GoogleSearchResultsStepDefs {
    private static final GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage();

    @Then("^I check the search results page is \"?(opened|closed)\"?$")
    public void iCheckTheSearchResultsPageIs(String state) {
        boolean isOpened = "opened".equals(state);
        Assert.assertEquals(googleSearchResultPage.verify(), isOpened,
                String.format("Search results is not '%s'", state));
    }

    @Then("^I check the list of searched items is more then \"([^\"]*)\"$")
    public void iCheckTheListOfSearchedItemsIsMoreThen(String expectedSize) {
        int actualListSize = googleSearchResultPage.getSearchResults.size();
        Assert.assertTrue(actualListSize > Integer.parseInt(expectedSize),
                String.format("Actual list size is '%s' and it's less then expected size '%s'",
                        actualListSize, expectedSize));
    }

    @Then("^I check the list of searched items contains \"([^\"]*)\"$")
    public void iCheckTheListOfSearchedItemsContains(String expectedValue) {
        googleSearchResultPage.getSearchResults.stream()
                .filter(item -> item.getText().contains(expectedValue))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Expected value '%s' doesn't present on actual searched list"));
    }

    @Then("^I check the searched items count is more then \"([^\"]*)\"$")
    public void iCheckTheSearchedItemsCountIsMoreThen(String expectedCount) {
        googleSearchResultPage.getSearchResultsCount().getText();
        String actualText = googleSearchResultPage.getSearchResultsCount().getText();
        String afterReplacement = actualText.replaceAll("\\D", "");
        Assert.assertTrue(Long.parseLong(afterReplacement) > Long.parseLong(expectedCount),
                String.format("Actual list size is '%s' and it's less then expected size '%s'",
                        afterReplacement, expectedCount));
    }
}
