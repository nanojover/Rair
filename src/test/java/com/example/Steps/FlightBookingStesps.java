package com.example.Steps;

import Pages.CheckOutPage;
import Pages.PaymentPage;
import Pages.SearchFlightsPage;
import Pages.SelectFlightsPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlightBookingStesps {
    private final String url = "https://www.ryanair.com/ie/en/";
    private WebDriver driver;
    private SearchFlightsPage flightsSelector;
    private SelectFlightsPage selectFlights;
    private CheckOutPage checkOutPage;
    private PaymentPage paymentPage;

    @Before()
    public void before(){
//        WebDriver driver = new ChromeDriver();
//        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "geckodrive/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    }


    @Given("^flights from '(.*)' on (.*) to '(.*)' on (.*)$")
    public void I_make_a_booking(String fromAiroport, String goDate, String toAirport, String backDate) {
        flightsSelector = new SearchFlightsPage(driver);
        flightsSelector.setAirports(fromAiroport, toAirport);
        flightsSelector.setDates(goDate, backDate);
    }

    @Given("^(\\d+) (adults|teens|children|infants) as passenger(?:s)$")
    public void set_passengers(int passengerQty, String passengerType) throws Throwable {
        flightsSelector.setPassengers(passengerQty, passengerType);
    }

    @Given("^proceed with the search of flights$")
    public void search() throws Throwable
    {
        flightsSelector.clickSearchFlight();
    }

    @Given("^flights are selected$")
    public void flights_are_selected() throws Throwable {
        selectFlights = new SelectFlightsPage(driver);
        selectFlights.selectFlights();
    }

    @Given("^proceed with checkout$")
    public void proceed_with_checkout() throws Throwable {
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickCheckOutAndProceed();
    }

    @Given("^proceed with login$")
    public void proceed_with_login() throws Throwable {
        paymentPage = new PaymentPage(driver);
        paymentPage.login();
    }

    @Given("^filling passenger details$")
    public void filling_passenger_details() throws Throwable {
        paymentPage.fillPassengerDetails();
    }

    @When("^I pay for booking with card details '(.*)', '(.*)' and '(.*)'$")
    public void pay_for_booking(String cardNumber, String date, String cvv2) throws Throwable {
        paymentPage.fillPaymentDetails(cardNumber, date, cvv2);
    }

    @Then("^a declined message is displayed$")
    public void a_declined_message_is_displayed() throws Throwable {

    }


}
