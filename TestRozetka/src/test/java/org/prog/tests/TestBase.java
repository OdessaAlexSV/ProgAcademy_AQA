package org.prog.tests;

import org.prog.pagemanager.RozetkaPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  protected final RozetkaPage rozetkaPage = new RozetkaPage();

  @BeforeSuite
  public void setUp() {
    rozetkaPage.init();
  }

  @AfterSuite
  public void tearDown() {
    rozetkaPage.stop();
  }

  @BeforeMethod
  public void loadPage() {
    rozetkaPage.loadPage("https://rozetka.com.ua");
  }
}
