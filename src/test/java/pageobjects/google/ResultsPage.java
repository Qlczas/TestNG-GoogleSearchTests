package pageobjects.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.PageUtils;

public class ResultsPage extends PageUtils {

    private static final By RESULTS_COLUMN = By.id("center_col");
    private static final By LINKS_LOCATOR = By.cssSelector("div.r a");

    public ResultsPage(WebDriver webDriver){
        super(webDriver);
        verifyElementVisible(RESULTS_COLUMN);
    }

    public void openUrlFromSearchResults(String givenUrlToOpen) {
        logText("### Starting step: When I want to open url from the search results: " + givenUrlToOpen);
        findAllElementsAndClickByGivenValue(LINKS_LOCATOR, givenUrlToOpen);
        getUrlAndConfirmIfOpened(givenUrlToOpen);
    }
}