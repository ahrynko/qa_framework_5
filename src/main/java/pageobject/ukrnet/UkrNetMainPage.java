package pageobject.ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

import java.util.Set;

public class UkrNetMainPage extends AbstractPage {

  private String currentWindowHandle ; //хранение ссылки текущего окна

  @FindBy(xpath = "//ul[@class='feed__section--top']//li[position()=1 or position()<2]")
  private WebElement firstArticle;

  public UkrNetMainPage(WebDriver webDriver) {
    super(webDriver);
  }

  public UkrNetArticleDetailsPage selectFirstArticle(){
    webDriverWait.until(ExpectedConditions.visibilityOf(firstArticle));

    //переключиться на новую табу
    firstArticle.click();

    currentWindowHandle = webDriver.getWindowHandle();  // вернет дискриптор окна( ID)

    System.out.println("Inside main page.Window handle is: "+ currentWindowHandle);

    Set<String> windowHandles = webDriver.getWindowHandles();// возврат набор (SET) открытых табов

    for (String windowHandle : windowHandles ){
      webDriver.switchTo().window(windowHandle);

    }

    /* while (windowHandles.iterator().hasNext()){
      String handle = windowHandles.iterator().next();
      if (!currentWindowHandle.equals(handle)){
        webDriver.switchTo().window(handle);
        System.out.println("Switched to next window. Handle is: "+ handle );
        break;
      }
    } */
    return new UkrNetArticleDetailsPage(webDriver);
  }

  //метод возврата текста с первого элемента
  public String getFirstArticleText(){
    return firstArticle.getText();
  }
}
