package hotline;

import common.BaseTest;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pageobject.hotline.model.HotlineItem;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.unitils.reflectionassert.ReflectionAssert;
import pageobject.hotline.HotlinePage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class HotlineTests extends BaseTest {

  private Logger logger = Logger.getLogger(HotlineTests.class); //зарегистрировали Logger класса

    @Test
    public void verifyHotlineAscendingSortingTest() throws IOException {

      logger.info("Start 'Verify Ascending Sorting Test'");

       WebDriver webDriver = getWebDriver();

      logger.info("Init 'Webdriver'");

       String url =("https://hotline.ua/mobile/chehly-sumki-futlyary-dlya-mobilnyh-i-smartfonov/71061-380639/");
       webDriver.get(url);

      logger.info(String.format("Opened following url '%s'",url));

       HotlinePage hotlinePage = new HotlinePage(webDriver);

        List<HotlineItem> unsortedHotlineItemsList = hotlinePage.getHotlineProducts();

//        unsortedHotlineItemsList.sort(Collections.reverseOrder());  //от большему к меньшему
        Collections.sort(unsortedHotlineItemsList);  // по возрастанию

        hotlinePage.orderBy("зростанням ціни");

        List<HotlineItem> sortedHotlineItemsList = hotlinePage.getHotlineItemsUsingStreamApi();

        ReflectionAssert.assertReflectionEquals("There is incorrect sorting found! ",
                unsortedHotlineItemsList,sortedHotlineItemsList);

    }
    @Test
    public void checkFirstItemsAreSortedInAscendingOrder(){

      WebDriver webDriver = getWebDriver();
      String url =("https://hotline.ua/mobile/chehly-sumki-futlyary-dlya-mobilnyh-i-smartfonov/71061-380639/");
      webDriver.get(url);
      HotlinePage hotlinePage = new HotlinePage(webDriver);

      List<HotlineItem> unsortedHotlineItemsList = hotlinePage.getHotlineProducts();
      Collections.sort(unsortedHotlineItemsList);  // по возрастанию

      hotlinePage.orderBy("зростанням ціни");
      List<HotlineItem> sortedHotlineItemsList = hotlinePage.getHotlineItemsUsingStreamApi();

      HotlineItem firstExpected = unsortedHotlineItemsList.get(0);
      HotlineItem firstActual = new HotlineItem("Some title",455); //sortedHotlineItemsList.get(0); //достали со страницы
      //SoftAssertions
      /*SoftAssertions softAssertions = new SoftAssertions();

      softAssertions.assertThat(firstExpected.getTitle())
              .as("Expected title")
              .isEqualTo(firstActual.getTitle());

      softAssertions.assertThat(firstExpected.getPrice())
              .as("Expected price")
              .isEqualTo(firstActual.getPrice());

      softAssertions.assertAll();*/

      Assert.assertEquals("There is incorrected title displayed!",firstExpected.getTitle(), firstActual.getTitle());
      Assert.assertEquals("There is incorrected price displayed!",firstExpected.getPrice(), firstActual.getPrice());
     // отработал только один Assert
    }

    @Test
    public void verifyHotlineDescendingSortingTest() {
        WebDriver webDriver = getWebDriver();
        String url = "https://hotline.ua/mobile/zaschitnaya-plenka-dlya-mobilnyh-telefonov/81002/";
        webDriver.get(url);
        logger.info(String.format("Opened following url '%s'",url));

        HotlinePage hotlinePage = new HotlinePage(webDriver);

        List<HotlineItem> unsortedHotlineItemsList = hotlinePage.getHotlineItemsUsingStreamApi();
        logger.info("Before sorting list");
        unsortedHotlineItemsList.sort(Collections.reverseOrder());
        logger.info("After sorting list");

        hotlinePage.orderBy("зменшенням ціни");
        logger.info("Click to orderSelect ");

        List<HotlineItem> sortedHotlineItemsList = hotlinePage.getHotlineItemsUsingStreamApi();
        ReflectionAssert.assertReflectionEquals("There is incorrect sorting found! ",
                unsortedHotlineItemsList,sortedHotlineItemsList);
        logger.info("Test passed");
    }
}
