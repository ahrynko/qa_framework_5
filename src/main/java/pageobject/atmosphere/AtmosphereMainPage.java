package pageobject.atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtmosphereMainPage {


  @FindBy(xpath = "//input[@placeholder='Search for shoes, jackets, water bottles and more']")
  private WebElement searchInput;

  @FindBy(xpath = "//input[@class='header-search__submit button']")
  private WebElement searchSubmitButton ;

  public AtmosphereMainPage(WebDriver webDriver){   //constructor class
    PageFactory.initElements(webDriver,this);
  }

  public void searchForParkas(String searchText){
    searchInput.sendKeys(searchText);
  }

  public void searchParkasPage(){
    searchSubmitButton.click();
  }
}
