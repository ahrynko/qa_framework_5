package pageobject.booking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.AbstractPage;

public class BookingMainPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement searchInput;
}
