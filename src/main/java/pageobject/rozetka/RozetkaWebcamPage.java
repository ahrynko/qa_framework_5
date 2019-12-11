package pageobject.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class RozetkaWebcamPage extends AbstractPage {

  public RozetkaWebcamPage(WebDriver webDriver) {
    super(webDriver);
  }

  @FindBy(xpath = "//i[contains(text(),'Razer')]")
  private WebElement filterRazer;

  @FindBy(xpath = "//div[@id='image_item194064']//img")
  private WebElement imageItem;

  public void choiceRazerCheckboxItem(){
    webDriverWait.until(ExpectedConditions.visibilityOf(imageItem));
    action.moveToElement(filterRazer).build().perform();
    filterRazer.click();
  }
}
