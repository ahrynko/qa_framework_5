package pageobject.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

import java.util.List;
import org.apache.log4j.Logger;
import java.util.stream.Collectors;

public class RozetkaWebcamPage extends AbstractPage {

  public RozetkaWebcamPage(WebDriver webDriver) {
    super(webDriver);
  }

  @FindBy(xpath = "//label[contains(text(),'Razer')]")
  private WebElement filterRazer;

  @FindBy(xpath = "//button[@class='button button_color_green button_size_medium search-form__submit']")
  private WebElement buttonSearchFormSubmit;

  @FindBys({
          @FindBy( xpath = "//a[@class='goods-tile__heading']//span[@class='goods-tile__title']")
  })
  private List<WebElement> webcamSearchListRazer; //list urls

  private Logger logger = Logger.getLogger(RozetkaWebcamPage.class); //зарегистрировали Logger класса

  public void choiceRazerCheckboxItem(){

    webDriverWait.until(ExpectedConditions.visibilityOf(buttonSearchFormSubmit));
    action.moveToElement(filterRazer).build().perform();
    webDriverWait.until(ExpectedConditions.visibilityOf(filterRazer));
    filterRazer.click();
    logger.info("We are choiced  filter Razer's model");
  }

  public List<String> getWebcamSearchListRazerText() { //method -который достанет список элементов
    webDriverWait.until(ExpectedConditions.invisibilityOfAllElements(webcamSearchListRazer));
    return webcamSearchListRazer
            .stream()
            .map(item -> item.getText())
//            .peek((e) -> System.out.print("," + e))
            .collect(Collectors.toList());
  }
}
