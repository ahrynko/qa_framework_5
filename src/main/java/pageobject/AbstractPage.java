package pageobject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.rozetka.RozetkaMainPage;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

@Data
public abstract class AbstractPage{  //выносим все общее

  protected WebDriver webDriver;  // copy link  driver
  protected WebDriverWait webDriverWait;
  protected Actions action;

  public AbstractPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    this.action = new Actions(webDriver);
    webDriverWait = new WebDriverWait(webDriver,30); // класс отвечает за явные ожидания
    webDriver.manage().window().maximize();
    webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); // класс отвечает за неявные ожидания (call 1 раз)
    PageFactory.initElements(webDriver,this);
  }
}
