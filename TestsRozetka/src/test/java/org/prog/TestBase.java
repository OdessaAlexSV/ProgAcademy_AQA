package org.prog;

import org.testng.annotations.AfterSuite;
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

}
