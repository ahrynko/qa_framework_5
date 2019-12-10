package google;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.google.GoogleSearchPage;
import pageobject.google.GoogleSearchResultsPage;
import pageobject.rozetka.RozetkaMainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleTestsSuite extends BaseTest {

  @Test
  public void verifyGooglePredictiveSearchFunctionality(){

    String googleUrl =  propertyHelper.readProperty("google.site.url");

    webDriver.get(googleUrl);

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
    String googleUrl =  propertyHelper.readProperty("google.site.url");
    webDriver.get(googleUrl);

    GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);

    GoogleSearchResultsPage resultsPage = googleSearchPage.searchForWithEnter("rozetka");

    String navUrl = resultsPage.getFirstUrl();
    webDriver.get(navUrl);

    RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(webDriver);
    rozetkaMainPage.getHeaderLogoTitle();
                                                      /* expected (То что на сайте)*/
    Assert.assertEquals("There is incorrect title present, opened via first url",
            "Інтернет-магазин Rozetka.ua - №1", rozetkaMainPage.getHeaderLogoTitle()); //UKR_Site

  }
}
