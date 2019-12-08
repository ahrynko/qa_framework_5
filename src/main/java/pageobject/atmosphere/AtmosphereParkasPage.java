package pageobject.atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtmosphereParkasPage {

  private WebDriver webDriver;

  public WebElement getChoiceItem() {
    return choiceItem;
  }

  @FindBy(xpath = "//img[@alt=\"Helly Hansen Men's Svalbard Insulated Parka\"]")
  private WebElement choiceItem;

  @FindBy(xpath = " //a[@data-value='42']")
  private WebElement choiceColourItem;

  @FindBy(xpath = "//a[@class='option-tiles__item '][2]")
  private WebElement choiceSizeItem;

  @FindBy(xpath = "//button[@class='add-cart product-detail__button product-detail__button-icon']")
  private WebElement addToCardItem;

  public AtmosphereParkasPage(WebDriver webDriver){  //constructor class
    PageFactory.initElements(webDriver,this);
  }

  public void choiceParakasItem(){
    choiceItem.click();
  }

  public void choiseParakasColourItem(){
    choiceColourItem.click();
  }

  public void choiseParakasSizeItem(){
    choiceSizeItem.click();
  }

  public void enterButtonParakasCardItem(){
    addToCardItem.click();
  }

  @FindBy(xpath = "//h1[@class='global-page-header__title']")
  public WebElement productParkaName;

  @FindBy(xpath = "//h3[@class='input-title product-detail__options-title']")
  public WebElement productParkaColour;

  @FindBy(xpath = "(//span[@class='option-tiles__item-title'])[2]")
  public WebElement productParkaSize;
}
