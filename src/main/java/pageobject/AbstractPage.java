package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage{  //выносим все общее

  protected WebDriver webDriver;  // copy link  driver
  protected WebDriverWait webDriverWait;

  public AbstractPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    webDriverWait = new WebDriverWait(webDriver,30); // класс отвечает за явные ожидания
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); // класс отвечает за неявные ожидания (call 1 раз)
    PageFactory.initElements(webDriver,this);
  }

}
