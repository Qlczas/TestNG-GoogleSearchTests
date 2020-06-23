package tests;

import org.testng.annotations.Test;


import pageobjects.google.MainSearchPage;
import pageobjects.google.ResultsPage;

public class GoogleTests extends BaseTests {

    private static final String TEST_PHRASE = "junit dependency";
    private static final String URL_TO_OPEN = "https://mvnrepository.com/artifact/junit/junit";

    @Test (priority = 1, description = "As a user, I would like to search for a phrase and open one of the pages from the results")
    public void testApplyingForGivenPosition() {
        MainSearchPage mainSearchPage = new MainSearchPage(driver.get());
        mainSearchPage.searchForTestPhrase(TEST_PHRASE);

        ResultsPage resultsPage = new ResultsPage(driver.get());
        resultsPage.openUrlFromSearchResults(URL_TO_OPEN);
    }
}
