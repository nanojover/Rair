package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class PaymentPage {
    WebDriver driver;
    List<String> credentials = Arrays.asList("nanojover@hotmail.com", "Ma123456");
    List<String> details = Arrays.asList("Mr", "Mariano", "Jover", "Spain", "603404698");
    List<String> cardDetails = Arrays.asList("MasterCard", "MJ", "The Street", "Barcelona", "08903", "Spain");

    By logIn = By.xpath("/html/body/div[2]/main/section/total-header/div/div/button[2]");
    //By email = By.name("emailAddress");
    //By email = By.cssSelector("name=\"emailAddress\"");
    //By email = By.xpath("//div[contains(text(),'");
    By email = By.xpath("//div[contains(text(),'email')]");
    //By email = By.className("core-input ng-pristine ng-empty ng-invalid ng-invalid-required ng-valid-email ng-touched");
    By password = By.name("name=\"password\"");
    By loginButton = By.xpath("/html/body/div[7]/div[2]/signup-home-form/div/div/div[2]/div/dialog-body/div[2]/signup-home-tabs/div[2]/div/div/div/form/div[4]/button-spinner/button");

    By title = By.xpath("//div[contains(text(),'title')]");
    By firstName = By.xpath("//div[contains(text(),'firstName')]");
    By surName = By.xpath("//div[contains(text(),'surName')]");

    By phoneNumberCountry = By.name("phoneNumberCountry");
    By phoneNumber = By.name("phoneNumber");

    By cardNumber = By.name("cardNumber");
    By cardType = By.name("cardType");
    By expiryMonth = By.name("expiryMonth");
    By expiryYear = By.name("expiryYear");
    By securityCode = By.name("securityCode");
    By cardHolderName = By.name("cardHolderName");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        CommonUtil.waitForElement(driver, logIn);
        driver.findElement(logIn).click();

        CommonUtil.waitForElement(driver, email);
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(credentials.get(0));

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(credentials.get(0));

        CommonUtil.waitForElement(driver, loginButton);
        driver.findElement(loginButton).click();

    }

    public void fillPassengerDetails() {

        driver.findElement(title).clear();
        driver.findElement(title).sendKeys(details.get(0));

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(details.get(1));

        driver.findElement(surName).clear();
        driver.findElement(surName).sendKeys(details.get(2));

        driver.findElement(phoneNumberCountry).clear();
        driver.findElement(phoneNumberCountry).sendKeys(details.get(3));

        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(details.get(4));
    }

    public void fillPaymentDetails(String cardNum, String date, String cvv2) {
        cardNum = cardNum.replaceAll(" ", "");
        driver.findElement(cardNumber).clear();
        driver.findElement(cardNumber).sendKeys(cardNum);

        driver.findElement(cardType).clear();
        driver.findElement(cardType).sendKeys(cardDetails.get(0));

        driver.findElement(expiryMonth).clear();
        driver.findElement(expiryMonth).sendKeys(date.substring(0, 2));

        driver.findElement(expiryYear).clear();
        driver.findElement(expiryYear).sendKeys(date.substring(3, 7));

        driver.findElement(securityCode).clear();
        driver.findElement(securityCode).sendKeys(cvv2);

        driver.findElement(cardHolderName).clear();
        driver.findElement(cardHolderName).sendKeys(cardDetails.get(1));

        name="billingAddressAddressLine1"
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(cardDetails.get(2));

        name="billingAddressCity"
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(cardDetails.get(3));

        name="billingAddressPostcode"
        driver.findElement(postalCode).clear();
        driver.findElement(postalCode).sendKeys(cardDetails.get(4));

        name="billingAddressCountry"
        driver.findElement(country).clear();
        driver.findElement(country).sendKeys(cardDetails.get(5));

        /html/body/div[2]/main/div[1]/payment/div[2]/div/form/div[1]/div[2]/div[2]/div[6]/div/label/span/core-icon/div/svg
                click
        By clicking Pay Now, I confirm I have read and accept Ryanair's General Terms and Conditions of carriage, Website Terms and Privacy statement    }
}
