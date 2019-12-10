package common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {

  protected WebDriver webDriver;
  protected WebDriverWait webDriverWait;
  protected PropertyHelper propertyHelper = new PropertyHelper();  // create Object propertyHelper

  @Before
  public void initDriver(){  //init driver
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    webDriver = new ChromeDriver();
  }

  @After
  public void shutDownDriver(){
    webDriver.close();
    webDriver.quit();
  }

}
