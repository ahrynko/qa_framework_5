package pageobject.atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.AbstractPage;

public class AtmosphereMainPage extends AbstractPage {


  @FindBy(xpath = "//input[@placeholder='Search for shoes, jackets, water bottles and more']")
  private WebElement searchInput;

  @FindBy(xpath = "//input[@class='header-search__submit button']")
  private WebElement searchSubmitButton ;

  public AtmosphereMainPage(WebDriver webDriver){   //constructor class
    super(webDriver);
  }

  public void searchForParkas(String searchText){
    searchInput.sendKeys(searchText);
  }

  public void searchParkasPage(){
    searchSubmitButton.click();
  }
}
