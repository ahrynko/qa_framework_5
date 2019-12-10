package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage{  //выносим все общее

  protected WebDriver webDriver;  // popy link  driver
  protected WebDriverWait webDriverWait; //

  public AbstractPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    webDriverWait = new WebDriverWait(webDriver,30); // класс отвечает за неявные ожидания
    PageFactory.initElements(webDriver,this);
  }

}
