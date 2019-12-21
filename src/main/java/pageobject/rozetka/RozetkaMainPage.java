package pageobject.rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.AbstractPage;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class RozetkaMainPage extends AbstractPage {

  @FindBy(xpath = "//a[@class='header__logo']/img")
  private WebElement headerLogo;

  @FindBy(xpath = "(//a[@class='menu-categories__link'])[1]")
  private WebElement menuCategoriesLink;

  @FindBy(xpath = "(//a[@class='menu__link'])[10]")
  private WebElement webCameraMenuLink;

  public RozetkaMainPage(WebDriver webDriver) {
    super(webDriver);
  }

  public String getHeaderLogoTitle(){  //method return LogoTitle
    webDriverWait.until(ExpectedConditions.visibilityOf(headerLogo));
    return headerLogo.getAttribute("title");
  }

  public RozetkaWebcamPage choiceWebCameraMenuLink(){
    action.moveToElement(menuCategoriesLink).build().perform();
    webDriverWait.until(ExpectedConditions.visibilityOf(webCameraMenuLink));
    action.moveToElement(webCameraMenuLink).build().perform();
    webCameraMenuLink.click();
    return new RozetkaWebcamPage(webDriver);
  }

}
