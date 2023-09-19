package org.prog;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class MainSearchTests extends TestBase {

  @Test(dataProvider = "goodNames")
  public void testRozetkaPage(String goodName) {
    rozetkaPage.setSearchFieldValue(goodName);
    System.out.println("Passed Parameter Is : " + goodName);
    Assert.assertTrue(rozetkaPage.isElementPresent(),"No any items in the result!");

    List<WebElement> searchResultItems = rozetkaPage.getSearchItems();
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
