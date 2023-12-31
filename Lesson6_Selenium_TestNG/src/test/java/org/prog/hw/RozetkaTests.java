package org.prog.hw;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RozetkaTests {

  private WebDriver wd;

  @BeforeSuite
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("profile.default_content_setting_values.cookies", 2);
    //prefs.put("profile.cookie_controls_mode", 2);
    options.addArguments("start-maximized");
    options.setExperimentalOption("prefs", prefs);
    wd = new ChromeDriver(options);
  }

  @BeforeMethod
  public void loadRozetkaPage() {
    wd.get("https://rozetka.com.ua");
  }

  @Test(dataProvider = "goodNames")
  public void testRozetkaPage(String goodName) {
    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10l));

    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
    WebElement inputSearch = wd.findElement(By.name("search"));
    inputSearch.sendKeys(goodName);
    inputSearch.sendKeys(Keys.ENTER);

    wait.until(ExpectedConditions.
            presenceOfAllElementsLocatedBy(By.xpath("//*[@class='goods-tile__inner']")));

     boolean searchOK = wd.findElements(By.xpath("//*[@class='goods-tile__title']"))
        .stream()
        .map(we -> we.getText())
        .anyMatch(text -> text.toLowerCase().contains(goodName.toLowerCase()));

    Assert.assertTrue(searchOK, "No " + goodName + " found!");
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
    if (wd != null) {
      wd.quit();
    }
  }
}
