package ukrnet;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.ukrnet.UkrNetArticleDetailsPage;
import pageobject.ukrnet.UkrNetMainPage;

public class UkrNetTestSuite extends BaseTest {

  @Test
  public void verifyUserIsAbleToNavigateToFirstArticleByClick(){

    String navUrl = propertyHelper.readProperty("ukrnet.main.page.url");
    webDriver.get(navUrl);

    UkrNetMainPage ukrNetMainPage = new UkrNetMainPage(webDriver);

    String expectedtArticleText = ukrNetMainPage.getFirstArticleText();

    UkrNetArticleDetailsPage ukrNetArticleDetailsPage = ukrNetMainPage.selectFirstArticle();

    String actualArticleText = ukrNetArticleDetailsPage.getArticleHeadText();

    Assert.assertEquals("There is incorrect article text displayed!",expectedtArticleText,actualArticleText);

  }

}
