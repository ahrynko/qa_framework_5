package pageobject.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

import java.util.List;
import java.util.stream.Collectors;

public class RozetkaWebcamPage extends AbstractPage {

  public RozetkaWebcamPage(WebDriver webDriver) {
    super(webDriver);
  }

  @FindBy(xpath = "//a[@name='producer_296']")
  private WebElement filterRazer;

  @FindBy(xpath = "(//a[@class='responsive-img centering-child-img'])[1]//img") // catalog image
  private WebElement firstCatalogImageWebcam;

  @FindBys({
          @FindBy( xpath = "//div[@class='g-i-tile-i-title clearfix']//a")
  })
  private List<WebElement> webcamSearchListRazer; //list urls

  public void choiceRazerCheckboxItem(){

    webDriverWait.until(ExpectedConditions.visibilityOf(firstCatalogImageWebcam));
    action.moveToElement(filterRazer).build().perform();
    webDriverWait.until(ExpectedConditions.elementToBeClickable(filterRazer));
    filterRazer.click();
  }

  public List<String> getWebcamSearchListRazerText() { //method -который достанет список элементов
    return webcamSearchListRazer
            .stream()
            .map(item -> item.getText())
            .peek(webcamSearchListRazerText -> webcamSearchListRazerText.toString())
            .collect(Collectors.toList());
    //конвертация списка вебэлементов в список строк
  }
}
