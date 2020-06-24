package pageobjects.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.PageUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MavenJUnitPage extends PageUtils {

    private static final By DOWNLOADS_TABLE = By.cssSelector(".grid.versions");
    private static final By DOWNLOADS_CELLS = By.cssSelector(".grid.versions a[href$='usages']");


    public MavenJUnitPage(WebDriver webDriver){
        super(webDriver);
        verifyElementVisible(DOWNLOADS_TABLE);
    }

    public void searchForMostDownloadedVersion(String givenVersion) {
        logText("### Starting step: Then I want to confirm that "
                + givenVersion + " is most downloaded one");
        findAllElementsAndAssertMostDownloaded(DOWNLOADS_CELLS, givenVersion);
    }

    private void findAllElementsAndAssertMostDownloaded(By elementLocator, String givenVersion) {
        ArrayList<Integer> sortedList = getMostDownloads(elementLocator);
        logText("### Actual Version with most Downloads is: "+ sortedList.get(0));

        By givenVersionDownloadsSelector = By.xpath("//a[@href='junit/"+ givenVersion +"']/parent::td/following-sibling::td[2]");
        WebElement givenVersionDownloadsCell = driver.findElement(givenVersionDownloadsSelector);
        System.out.println("##Test " + givenVersionDownloadsCell.getText());
        int givenVersionDownloads = Integer.parseInt(givenVersionDownloadsCell.getText().replace(",",""));
        logText("### Expected Version with most Downloads is: "+ givenVersionDownloads);
        assertEquals(java.util.Optional.of(givenVersionDownloads), java.util.Optional.of(sortedList.get(0)));
    }

    private ArrayList<Integer> getMostDownloads(By elementLocator) {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(elementLocator);
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (String s : obtainedList) {
            int i = Integer.parseInt(s.replace(",",""));
            sortedList.add(i);
        }
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        return sortedList;
    }
}