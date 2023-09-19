package org.prog;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RozetkaPage {
  private final By SEARCH_ITEM_RESULT_TITLE_LOCATOR =
      By.xpath("//*[@class='goods-tile__heading ng-star-inserted']");
  private WebDriver driver;
  private WebDriverWait wait;
  private boolean acceptNextAlert = true;

  protected void init() {
    ChromeOptions options = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("profile.default_content_setting_values.cookies", 2);
    //prefs.put("profile.cookie_controls_mode", 2);
    options.addArguments("start-maximized");
    options.setExperimentalOption("prefs", prefs);
    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
  }

  @BeforeMethod
  public void loadRozetkaPage() {
    driver.get("https://rozetka.com.ua");
  }

  protected void setSearchFieldValue(String goodName) {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
    WebElement inputSearch = driver.findElement(By.name("search"));
    inputSearch.sendKeys(goodName);
    inputSearch.sendKeys(Keys.ENTER);

    wait.until(ExpectedConditions.
        presenceOfAllElementsLocatedBy(By.xpath("//*[@class='goods-tile__inner']")));
  }

  protected boolean getSearchItem(String goodName) {
    return driver.findElements(By.xpath("//*[@class='goods-tile__title']"))
        .stream()
        .map(we -> we.getText())
        .anyMatch(text -> text.toLowerCase().contains(goodName.toLowerCase()));
  }

  protected void stop() {
    if (driver != null) {
      driver.quit();
    }
  }

  protected boolean isElementPresent() {
    try {
      driver.findElement(SEARCH_ITEM_RESULT_TITLE_LOCATOR);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  protected List<WebElement> getSearchItems() {
    return driver.findElements(SEARCH_ITEM_RESULT_TITLE_LOCATOR);
  }
}
