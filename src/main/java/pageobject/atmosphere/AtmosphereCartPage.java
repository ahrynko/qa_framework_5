package pageobject.atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtmosphereCartPage {

  @FindBy(xpath = "//a[@class='header-cart__trigger drawer-ui__toggle']")
  private WebElement cart;

  public AtmosphereCartPage(WebDriver webDriver){ //constructor class
    PageFactory.initElements(webDriver,this);
  }

  public void parakasItemInCart(){
    cart.click();
  }

  @FindBy(xpath = "//a[@class='sc-product__title-link']")
  public WebElement productParkaName;
}
