package pageobject.w3school;

import org.apache.log4j.Logger;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class W3SchoolMainPage extends AbstractPage {

  @FindBy(xpath = "//iframe[@src='default.asp']")
  private WebElement iframe;

  @FindBy(xpath = "//a[@title='JavaScript Tutorial']")
  private WebElement menuItem;

  @FindBy(xpath = "//a[@title='Home']")
  private WebElement homeButton;

  private Logger logger = Logger.getLogger(W3SchoolMainPage.class); //зарегистрировали Logger класса

  public W3SchoolMainPage(WebDriver webDriver) {
    super(webDriver);
  }

  public void selectMenuItem(){
    webDriver.switchTo().frame(iframe); //переключ в iframe
    logger.debug("We are in iframe");
    webDriverWait.until(ExpectedConditions.elementToBeClickable(menuItem));
    try {
      menuItem.click();
    } catch (NotFoundException e) {
      logger.trace("Element not found exception!",e.fillInStackTrace());
    }
    action.moveToElement(homeButton).build().perform();
  }

  public String getSelectedMenuItemColor() {
    return menuItem.getCssValue("background-color"); //CssValue по key

  }

}
