package pageobjects.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.PageUtils;

public class MainSearchPage extends PageUtils {

    private static String GOOGLE_MAIN_URL = "https://www.google.com/";

    private static final By MAIN_PAGE_CONTAINER = By.id("body");
    private static final By SEARCH_INPUT = By.cssSelector("form[role='search'] input[role='combobox']");

    public MainSearchPage(WebDriver webDriver){
        super(webDriver);
        logText("### Starting step: Given Google Search page is visible");
        openPage(GOOGLE_MAIN_URL);
        getUrlAndConfirmIfOpened(GOOGLE_MAIN_URL);
        verifyElementVisible(MAIN_PAGE_CONTAINER);
        verifyElementVisible(SEARCH_INPUT);
    }

    public void searchForTestPhrase(String testPhrase) {
        logText("### Starting step: When I search for a Phrase: " + testPhrase);
        verifyElementVisible(SEARCH_INPUT);
        scrollToElement(SEARCH_INPUT);
        addTextToElement(SEARCH_INPUT, testPhrase);
    }

    public void openGivenUrlResult(String urlToOpen) {
        logText("### Starting step: I open the link from list of results: " + urlToOpen);

    }
}