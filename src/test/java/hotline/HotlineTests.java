package hotline;

import common.BaseTest;
import common.model.HotlineItem;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.unitils.reflectionassert.ReflectionAssert;
import pageobject.hotline.HotlinePage;

import java.util.Collections;
import java.util.List;

public class HotlineTests extends BaseTest {

    @Test
    public void verifyHotlineAscendingSortingTest(){
       WebDriver webDriver = getWebDriver();
       webDriver.get("https://hotline.ua/mobile/chehly-sumki-futlyary-dlya-mobilnyh-i-smartfonov/71061-380639/");
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
