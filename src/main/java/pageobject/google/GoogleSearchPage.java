package pageobject.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import pageobject.AbstractPage;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchPage extends AbstractPage {

  @FindBy(name="q") //поиск одного элемента !!!Нужно экранировать пробел!!
  private WebElement searchInput; //объявляем наш элемент

  @FindBys({                      //принимает значение массива
          @FindBy(xpath = "//li[@class='sbct' and not (@id='sbt')]")
  })
  private List<WebElement> predictiveSearchList;

  public GoogleSearchPage(WebDriver webDriver){  //протащили webDriver в конструктор (взаимодействие со страницей)
    super(webDriver);
  }

  public void searchFor(String searchText){  //method -протащили в конструктор, искать любой текст
    //wait
    searchInput.sendKeys(searchText);   //enter text
  }

  public List<String> getPredictiveSearchListText() {   //method -который достанет список элементов
    return predictiveSearchList
            .stream()     //обработка коллекций через потоки
            .map(item -> item.getText())     //method map -который умеет превращать одно состояние в другое
            //.map(WebElement::getText) - упрощенная запись - метод референс, для обработки одного элемента
            //.map(item -> Integer.parseInt(item))   // парсить строку в число
            .collect(Collectors.toList());     //method collect - собирает список в LIST
    //конвертация списка вебэлементов в список строк
  }
}
