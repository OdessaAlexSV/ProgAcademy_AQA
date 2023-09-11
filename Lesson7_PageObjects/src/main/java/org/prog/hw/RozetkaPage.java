package org.prog.hw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RozetkaPage extends AbstractPage {
  private final By INPUT_SEARCH_FIELD_LOCATOR = By.name("search");
  private final By SEARCH_ITEM_RESULT_TITLE_LOCATOR = By.xpath("//*[@class='goods-tile__heading ng-star-inserted']");
  WebDriverWait wait;

  public RozetkaPage(WebDriver driver) {
    super(driver, "https://rozetka.com.ua");
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
  }

  public void setSearchFieldValue(String value) {
    wait.until(ExpectedConditions.presenceOfElementLocated(INPUT_SEARCH_FIELD_LOCATOR));
    WebElement inputSearch = driver.findElement(By.name("search"));
    inputSearch.sendKeys(value);
    inputSearch.sendKeys(Keys.ENTER);
  }

  public boolean isSearchResultPresents() {
    WebElement foundItem = wait.until(ExpectedConditions.
        visibilityOfElementLocated(SEARCH_ITEM_RESULT_TITLE_LOCATOR));
    return foundItem.isDisplayed();
  }

  public List<WebElement> getSearchItems() {
    return driver.findElements(SEARCH_ITEM_RESULT_TITLE_LOCATOR);
  }

}
