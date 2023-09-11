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

  WebDriverWait wait;

  public RozetkaPage(WebDriver driver) {
    super(driver, "https://rozetka.com.ua");
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
  }

  public void setSearchFieldValue(String value) {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
    WebElement inputSearch = driver.findElement(By.name("search"));
    inputSearch.sendKeys(value);
    inputSearch.sendKeys(Keys.ENTER);
  }

  public boolean isSearchResultPresents() {
    List<WebElement> foundItems = wait.until(ExpectedConditions.
        presenceOfAllElementsLocatedBy(By.xpath("//*[@class='goods-tile__inner']")));
    return foundItems.size() > 0;
  }

  public List<WebElement> getSearchItems() {
    return driver.findElements(By.xpath("//*[@class='goods-tile__title']"));
  }

}
