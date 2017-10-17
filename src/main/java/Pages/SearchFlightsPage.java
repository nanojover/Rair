package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchFlightsPage {
    WebDriver driver;

    By departureAirportName = By.cssSelector("[aria-labelledby=\"label-airport-selector-from\"]");
    By destinationAirportName = By.cssSelector("[aria-labelledby=\"label-airport-selector-to\"]");
//    aria-labelledby="label-airport-selector-to"

    By dayOut = By.cssSelector("[aria-label=\"Fly out: - DD\"]");
//    By dayOut = By.cssSelector("name=\"dateInput0\" placeholder=\"DD\"");

    By monthOut = By.cssSelector("[aria-label=\"Fly out: - MM\"]");
    By yearOut = By.cssSelector("[aria-label=\"Fly out: - YYYY\"]");

    By dayBack = By.cssSelector("[aria-label=\"Fly back: - DD\"]");
    By monthBack = By.cssSelector("[aria-label=\"Fly back: - MM\"]");
    By yearBack = By.cssSelector("[aria-label=\"Fly back: - YYYY\"]");

    By searchButton = By.cssSelector("[ng-click=\"searchFlights()\"]");

    By adult = By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]");
    //    By adult = By.cssSelector("aria-label=\"1 adulto (Mayores de 16+)\"");
    //    By adult = By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]");
    By adultsQty = By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[1]/input");
    By teensQty = By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/popup-content/div[7]/div/div[1]/input");
    By childrenQty = By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/popup-content/div[8]/div/div[1]/input");
    By infantsQty = By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/popup-content/div[9]/div/div[1]/input");

    public SearchFlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setAirports(String departure, String destination) {
        CommonUtil.waitForElement(driver, departureAirportName);
        driver.findElement(departureAirportName).clear();
        driver.findElement(departureAirportName).sendKeys(departure);
        driver.findElement(departureAirportName).sendKeys(Keys.RETURN);
        driver.findElement(destinationAirportName).clear();
        driver.findElement(destinationAirportName).sendKeys(destination);
        driver.findElement(destinationAirportName).sendKeys(Keys.RETURN);
    }

    public void setDates(String out, String back) {
        CommonUtil.waitForElement(driver, dayOut);
        driver.findElement(dayOut).click();
        driver.findElement(dayOut).clear();
        driver.findElement(dayOut).sendKeys(String.valueOf(out.substring(0, 2)));
        driver.findElement(monthOut).clear();
        driver.findElement(monthOut).sendKeys(String.valueOf(out.substring(3, 5)));
        driver.findElement(yearOut).clear();
        driver.findElement(yearOut).sendKeys(String.valueOf(out.substring(6, 10)));

        CommonUtil.waitForElement(driver, dayBack);
        driver.findElement(dayBack).click();
        driver.findElement(dayBack).clear();
        driver.findElement(dayBack).sendKeys(String.valueOf(back.substring(0, 2)));
        driver.findElement(monthBack).clear();
        driver.findElement(monthBack).sendKeys(String.valueOf(back.substring(3, 5)));
        driver.findElement(yearBack).clear();
        driver.findElement(yearBack).sendKeys(String.valueOf(back.substring(6, 10)));
    }

    public void setPassengers(int passengerQty, String passengerType) {
        driver.findElement(adult).click();
        if ("adults".equals(passengerType.toLowerCase())) {
            CommonUtil.waitForElement(driver, adultsQty);
            driver.findElement(adultsQty).clear();
            driver.findElement(adultsQty).sendKeys(String.valueOf(passengerQty)+Keys.RETURN);
        } else if ("teens".equals(passengerType.toLowerCase())) {
            CommonUtil.waitForElement(driver, teensQty);
            driver.findElement(teensQty).clear();
            driver.findElement(teensQty).sendKeys(String.valueOf(passengerQty)+Keys.RETURN);
        } else if ("children".equals(passengerType.toLowerCase())) {
            CommonUtil.waitForElement(driver, childrenQty);
            driver.findElement(childrenQty).clear();
            driver.findElement(childrenQty).sendKeys(String.valueOf(passengerQty)+Keys.RETURN);
        } else if ("infant".equals(passengerType.toLowerCase())) {
            CommonUtil.waitForElement(driver, infantsQty);
            driver.findElement(infantsQty).clear();
            driver.findElement(infantsQty).sendKeys(String.valueOf(passengerQty)+Keys.RETURN);
        }
    }

    public void clickSearchFlight() {
        driver.findElement(searchButton).click();
    }
}
