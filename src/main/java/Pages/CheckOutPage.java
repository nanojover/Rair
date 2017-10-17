package Pages;

import Pages.util.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;

    By checkOutButton = By.cssSelector("html.no-js.wf-roboto-n4-active.wf-roboto-n7-active.wf-bebasneue-n4-active.wf-active body.sso-enabled.mandatory-seats-enabled.mandatory-sign-in.checkin-products-fasttrack.checkin-products-bags.checkin-products-insurance.past-trips-enabled.express-booking-enabled.checkin-products-cabin-bag.ryanair-holidays-search-widget.change-seats-enabled.checkin-products-priority-boarding.plus-upgrade-card.coras-event.checkin-plus-upgrade-card.checkin-products-breakfast.new-potential-trip-enabled.promotion-car-hire-pt-pop-up.family-plus-upgrade-card.leaderboard-carhire-discount.promotion-group-booking-popup.erasmus-tab-enabled.only20kgbagavailable.disable-seats-pb-discount-popup.disable-fasttrack-pb-discount-popup.website-terms-checkbox-enabled.tpl-homepage.homepage div.FR main section total-header.header-section section#booking-selection article.container div.cart.cart-empty section div.trips-basket.trips-cnt button.core-btn-primary.core-btn-block.core-btn-medium.btn-text");
    By okButton = By.xpath("/html/body/div[7]/div[2]/div[1]/div[1]/div[2]/button[2]");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckOutAndProceed() {
        CommonUtil.waitForElement(driver, checkOutButton);
        driver.findElement(checkOutButton).click();
        CommonUtil.waitForElement(driver, okButton);
        driver.findElement(okButton).click();

    }
}
