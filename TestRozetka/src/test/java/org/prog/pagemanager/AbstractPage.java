package org.prog.pagemanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPage {

  protected WebDriver driver;
  protected WebDriverWait wait;
  private boolean acceptNextAlert = true;

  public void init() {
   ChromeOptions options = new ChromeOptions();
   Map<String, Object> prefs = new HashMap<>();
   prefs.put("profile.default_content_setting_values.cookies", 2);
   //prefs.put("profile.cookie_controls_mode", 2);
   options.addArguments("start-maximized");
   options.setExperimentalOption("prefs", prefs);
   driver = new ChromeDriver(options);
   wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
 }

  public void stop() {
   if (driver != null) {
     driver.quit();
   }
 }

  public void loadPage(String url) {
    driver.get("about::blank");
    driver.get(url);
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
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
}
