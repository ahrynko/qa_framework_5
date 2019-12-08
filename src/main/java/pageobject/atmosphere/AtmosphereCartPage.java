package pageobject.atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.AbstractPage;

public class AtmosphereCartPage extends AbstractPage {

  @FindBy(xpath = "//a[@class='header-cart__trigger drawer-ui__toggle']")
  private WebElement cart;

  public AtmosphereCartPage(WebDriver webDriver){ //constructor class
    super(webDriver);
  }

  public void parakasItemInCart(){
    cart.click();
  }

  @FindBy(xpath = "//a[@class='sc-product__title-link']")
  public WebElement productParkaName;
}
