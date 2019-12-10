package google;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.google.GoogleSearchPage;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleTestsSuite extends BaseTest {

  @Test
  public void verifyGooglePredictiveSearchFunctionality(){
    webDriver.get("https://www.google.com/");
    webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

    GoogleSearchPage searchPage = new GoogleSearchPage(webDriver);
    searchPage.searchFor("rozetka");

    List<String> predictiveSearchList = searchPage.getPredictiveSearchListText();
    Assert.assertFalse("There are not item found! ",predictiveSearchList.isEmpty()); // проверка что List - не пустой

    predictiveSearchList.forEach(item -> { //item - строка,
      Assert.assertTrue("There is not such item present!",item.contains("rozetka")); // {анонимное тело функции}
    });
  }

  @Test
  public void verifyGoogleSearch(){

  }
}
