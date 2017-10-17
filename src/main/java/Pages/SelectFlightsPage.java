package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectFlightsPage {
    WebDriver driver;

    By departureFlight = By.xpath("/html/body/div[2]/main/div[1]/section/div/div/flight-list[1]/form/div[3]/div/flights-table/div/div[1]/div[1]/flights-table-header/div/div[2]/flights-table-price/div/div[2]");
    By destinationFlight = By.xpath("/html/body/div[2]/main/div[1]/section/div/div/flight-list[2]/form/div[3]/div/flights-table/div/div[1]/div[1]/flights-table-header/div/div[2]/flights-table-price/div/div");

    By fareOut = By.xpath("/html/body/div[2]/main/div[1]/section/div/div/flight-list[1]/form/div[3]/div/flights-table/div/div[1]/div[1]/div/flights-table-fares/div/div[1]/div[1]/div[5]");
    By fareBack = By.xpath("/html/body/div[2]/main/div[1]/section/div/div/flight-list[2]/form/div[3]/div/flights-table/div/div[1]/div[1]/div/flights-table-fares/div/div[1]/div[1]/div[5]");

    By continueButton = By.xpath("/html/body/div[2]/main/section/total-header/section[2]/article/div[2]/section/div[2]/button");

    public SelectFlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFlights() {
        CommonUtil.waitForElement(driver, departureFlight);
        driver.findElement(departureFlight).click();
        CommonUtil.waitForElement(driver, fareOut);
        driver.findElement(fareOut).click();
        CommonUtil.waitForElement(driver, destinationFlight);
        driver.findElement(destinationFlight).click();
        CommonUtil.waitForElement(driver, fareBack);
        driver.findElement(fareBack).click();
        CommonUtil.waitForElement(driver, continueButton);
        driver.findElement(continueButton).click();
    }


}
