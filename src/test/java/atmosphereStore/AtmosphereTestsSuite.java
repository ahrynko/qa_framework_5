package atmosphereStore;

import common.BaseTest;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.atmosphere.AtmosphereCartPage;
import pageobject.atmosphere.AtmosphereMainPage;
import pageobject.atmosphere.AtmosphereParkasPage;

import java.util.concurrent.TimeUnit;

public class AtmosphereTestsSuite extends BaseTest {

  @Test
  public void verifyAddItemToCartFunctionality (){

    String atmosphereUrl = propertyHelper.readProperty("atmosphere.site.url");

    webDriver.get(atmosphereUrl);

    AtmosphereMainPage searchPage = new AtmosphereMainPage(webDriver);
    searchPage.searchForParkas("PARKAS");
    searchPage.searchParkasPage();

    AtmosphereParkasPage parkasPage = new AtmosphereParkasPage(webDriver);

    Actions builder = new Actions(webDriver);
    builder.moveToElement(parkasPage.getChoiceItem()).build().perform();

    parkasPage.choiceParakasItem();

    String  actualNameProductPage  = parkasPage.productParkaName.getText();

    JavascriptExecutor jsx = (JavascriptExecutor)webDriver;
    jsx.executeScript("window.scrollBy(0,400)", "");

    parkasPage.choiseParakasColourItem();
    String  actualColourProductPage = parkasPage.productParkaColour.getText();

    parkasPage.choiseParakasSizeItem();
    String  actualSizeProductPage = parkasPage.productParkaSize.getText();
    parkasPage.enterButtonParakasCardItem();

    AtmosphereCartPage cartPage = new AtmosphereCartPage(webDriver);
    cartPage.parakasItemInCart();

    String expectedNameProductCart = cartPage.productParkaName.getText();
    String expectedColourProductCart = "COLOUR: NORTH SEA BLUE - 603";
    String expectedSizeProductPage = "M";

    Assert.assertEquals("You have incorrectly selected the name in the CART",expectedNameProductCart,actualNameProductPage);
    Assert.assertEquals("You have incorrectly selected the colour in the CART",expectedColourProductCart,actualColourProductPage);
    Assert.assertEquals("You have incorrectly selected the size in the CART",expectedSizeProductPage,actualSizeProductPage);

  }
}
