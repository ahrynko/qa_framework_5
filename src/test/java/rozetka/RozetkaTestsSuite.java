package rozetka;

import common.BaseTest;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import pageobject.rozetka.RozetkaMainPage;
import pageobject.rozetka.RozetkaWebcamPage;

public class RozetkaTestsSuite extends BaseTest {

  @Test
  public void verifyProductFiltration(){

    String rozetkaUrl = propertyHelper.readProperty("rozetka.site.url");
    webDriver.get(rozetkaUrl);

    RozetkaMainPage searchPage = new RozetkaMainPage(webDriver);
    searchPage.choicewebCameraMenuLink();

    RozetkaWebcamPage webcamPage = new RozetkaWebcamPage(webDriver);
    webcamPage.choiceRazerCheckboxItem();

  }
}
