package pageobject.hotline;

import common.data.PartialUrl;
import pageobject.hotline.model.HotlineItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import pageobject.AbstractPage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "/mobile/chehly-sumki-futlyary-dlya-mobilnyh-i-smartfonov/71061-380639/")
public class HotlinePage extends AbstractPage{

    @FindBys({
            @FindBy(xpath = "//li[@class='product-item']")
    })
    private List<WebElement> hotlineProducts;

    @FindBy(xpath = "//select[@name='sort']")
    private WebElement sortSelect;

    private static final String TITLE_LOCATOR = ".//p[@class='h4']"; // ./- взять child with parent = hotlineProducts
    private static final String PRICE_LOCATOR = ".//span[@class='value']";

    private WebDriver webDriver;

    public HotlinePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void orderBy(String text){ //метод сортировки по тексту
        Select orderSelect = new Select(sortSelect);
        orderSelect.selectByVisibleText(text);
    }
    public List<HotlineItem> getHotlineProducts(){  //метод возврата списка объектов HotlineItem

        List<HotlineItem> hotlineItems = new ArrayList<>();

        for (WebElement product : hotlineProducts){

            String title = product.findElement(By.xpath(TITLE_LOCATOR)).getText();
            Integer price = Integer.valueOf(product.findElement(By.xpath(PRICE_LOCATOR)).getText());

            HotlineItem hotlineItem = new HotlineItem(title,price);
            hotlineItems.add(hotlineItem); //добавление в коллекцию List<HotlineItem
        }
        return hotlineItems;
    }

    public List<HotlineItem> getHotlineItemsUsingStreamApi(){ //метод возврата списка объектов HotlineItem через StreamApi
        return hotlineProducts
                .stream()
                .map(product -> {  // преобраз. одного сосотояния в другое
                    String title = product.findElement(By.xpath(TITLE_LOCATOR)).getText();
                    Integer price = Integer.valueOf(product.findElement(By.xpath(PRICE_LOCATOR)).getText());
                    return new HotlineItem(title,price);
                }).collect(Collectors.toList());

    }

}
