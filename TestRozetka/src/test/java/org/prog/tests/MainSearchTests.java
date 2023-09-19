package org.prog.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.prog.pagemanager.RozetkaPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.List;

public class MainSearchTests extends TestBase {

    private final By SEARCH_ITEM_RESULT_TITLE_LOCATOR =
        By.xpath("//*[@class='goods-tile__heading ng-star-inserted']");

    @Test(dataProvider = "goodNames")
    public void testMainSearchRozetkaPage(String goodName) {
        rozetkaPage.setSearchFieldValue(goodName);
        System.out.println("Passed Parameter Is : " + goodName);
        Assert.assertTrue(rozetkaPage.isElementPresent(SEARCH_ITEM_RESULT_TITLE_LOCATOR),"No any items in the result!");

        List<WebElement> searchResultItems = rozetkaPage.getSearchItems(SEARCH_ITEM_RESULT_TITLE_LOCATOR);

        Assert.assertTrue(searchResultItems
            .stream()
            .map(we -> we.getText())
            .anyMatch(text -> text.toLowerCase().contains(goodName.toLowerCase())),"No " + goodName + " found!");
    }

    @DataProvider(name = "goodNames")
    public Object[][] goodNames() {
        return new Object[][]{
            {"IPhone"},
            {"Nokia"},
            {"Samsung"},
            {"Joe Biden"}
        };
    }
}
