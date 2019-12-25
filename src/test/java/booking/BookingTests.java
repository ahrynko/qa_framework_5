package booking;

import common.BaseTest;
import common.helper.PropertyHelper;
import org.junit.Assert;
import org.junit.Test;
import pageobject.booking.BookingMainPage;
import pageobject.booking.BookingResultsPage;
import pageobject.booking.panels.BookingCalendarPanel;

import java.io.IOException;

public class BookingTests extends BaseTest {

    private PropertyHelper propertiesHelper;

    public BookingTests() throws IOException {
        propertiesHelper = new PropertyHelper();
    }

    @Test
    public void verifySearchWorksAsExpectedTest(){

        String navigationUrl = propertyHelper.readProperty("booking.main.page.url");
        getWebDriver().get(navigationUrl);

        BookingMainPage bookingMainPage = new BookingMainPage(getWebDriver());

        bookingMainPage.typeTravelPlace("Мілан");
        BookingCalendarPanel calendar = bookingMainPage.openTravelingCalendar();
        calendar.selectTravelDate("20","березень 2020"); //March

        BookingResultsPage bookingResultsPage = bookingMainPage.performSearch();

        String firstHotel = bookingResultsPage.getFirstAvailableHotelDestination();

        Assert.assertEquals("There is incorrect first destination displayed!",
                "Мілан", firstHotel);
    }
}
