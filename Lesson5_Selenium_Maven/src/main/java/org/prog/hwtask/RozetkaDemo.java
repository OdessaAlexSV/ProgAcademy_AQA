package org.prog.hwtask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RozetkaDemo {

  public static void main(String[] args) {
    WebDriver webDriver = null;
    try {
      webDriver = new ChromeDriver();
      webDriver.get("https://rozetka.com.ua");
      WebElement inputSearch = webDriver.findElement(By.name("search"));
      inputSearch.sendKeys("Iphone");
      inputSearch.sendKeys(Keys.ENTER);
    } finally {
      if (webDriver != null)
        webDriver.quit();
    }
  }
}
