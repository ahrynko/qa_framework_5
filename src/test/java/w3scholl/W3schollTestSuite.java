package w3scholl;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.w3school.W3SchoolMainPage;

public class W3schollTestSuite extends BaseTest {

  @Test
  public void verifySelectedMenuItemColour(){

    String navigationUrl = propertyHelper.readProperty("w3c.school.page.url");
    webDriver.get(navigationUrl);

    W3SchoolMainPage w3SchoolMainPage = new W3SchoolMainPage(webDriver);
    w3SchoolMainPage.selectMenuItem();

    String expectedColour = "#4CAF50"; //rgba(76, 175, 80, 1)
    String actualColour = w3SchoolMainPage.getSelectedMenuItemColor();

    Assert.assertEquals("There is incorrect selected menu item colour ",expectedColour,actualColour);

  }
}

