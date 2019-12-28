package rozetka;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import pageobject.rozetka.RozetkaMainPage;
import pageobject.rozetka.RozetkaWebcamPage;

import java.util.List;

public class RozetkaTestsSuite extends BaseTest {

  @Test
  public void verifyProductFiltration(){

    String rozetkaUrl = propertyHelper.readProperty("rozetka.site.url");
    webDriver.get(rozetkaUrl);

    RozetkaMainPage searchPage = new RozetkaMainPage(webDriver);
    searchPage.choiceWebCameraMenuLink();

    RozetkaWebcamPage webcamPage = new RozetkaWebcamPage(webDriver);
    webcamPage.choiceRazerCheckboxItem();

    List<String> webcamSearchListRazer = webcamPage.getWebcamSearchListRazerText();
    Assert.assertFalse("There are not item found! ",webcamSearchListRazer.isEmpty()); //проверка что List не пустой

    System.out.print(webcamSearchListRazer);

    webcamSearchListRazer.forEach(item -> { //item - строка,
      Assert.assertTrue("There is not such item present! ",item.contains("Razer")); // {анонимное тело функции}
    });
    System.out.print(webcamSearchListRazer);
    System.out.print(webcamSearchListRazer.size());
  }
}
