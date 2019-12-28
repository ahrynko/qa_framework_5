package hotline;

import common.BaseTest;
import org.apache.log4j.Logger;
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

}
