package org.prog.pagemanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class RozetkaPage extends AbstractPage {

  public void setSearchFieldValue(String goodName) {
      wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
      WebElement inputSearch = driver.findElement(By.name("search"));
      inputSearch.sendKeys(goodName);
      inputSearch.sendKeys(Keys.ENTER);

      wait.until(ExpectedConditions.
          presenceOfAllElementsLocatedBy(By.xpath("//*[@class='goods-tile__inner']")));
  }

  public List<WebElement> getSearchItems(By by) {
    return driver.findElements(by);
  }

}
