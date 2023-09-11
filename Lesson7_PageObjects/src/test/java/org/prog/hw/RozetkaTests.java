package org.prog.hw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.classwork.pages.GoogleCalendarPage;
import org.prog.classwork.pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RozetkaTests {

  private RozetkaPage rozetkaPage;

  @BeforeSuite
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("profile.default_content_setting_values.cookies", 2);
  //prefs.put("profile.cookie_controls_mode", 2);
    options.addArguments("start-maximized");
    options.setExperimentalOption("prefs", prefs);
    WebDriver wd = new ChromeDriver(options);
    rozetkaPage = new RozetkaPage(wd);
  }

  @BeforeMethod
  public void loadRozetkaPage() {
    rozetkaPage.loadPage();
  }

  @Test(dataProvider = "goodNames")
  public void testRozetkaPage(String goodName) {
     rozetkaPage.setSearchFieldValue(goodName);
     System.out.println("Passed Parameter Is : " + goodName);
     Assert.assertTrue(rozetkaPage.isSearchResultPresents(),
        "No any items in the result!");

    List<WebElement> searchResultItems = rozetkaPage.getSearchItems();;

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

  @AfterSuite
  public void tearDown() {
    rozetkaPage.quitDriver();
  }
}
