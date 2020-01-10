package com.list.am_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.list.am_automation.helpers.DriverHelper.getDriver;
import static com.list.am_automation.helpers.WaitHelper.waitForElementToBeClickable;
import static com.list.am_automation.helpers.WaitHelper.waitForVisibilityOfElement;
import static org.testng.AssertJUnit.assertTrue;

public class PhoneCategoryPage extends BasePage <PhoneCategoryPage> {

    public static final String PHONE_PAGE_URL = "https://www.list.am/category/11";

    @FindBy(id = "idcmtype0")
    private WebElement radio_button_private; // Who are we dealing with

    @FindBy(id = "idcmtype1")
    private WebElement radio_button_organization; // Who are we dealing with

    @FindBy(id = "idtype0")
    private WebElement radio_button_forSale; // For Sale

    @FindBy(id = "idtype1")
    private WebElement radio_button_exchange; // Exchange

    @FindBy(id = "idtype2")
    private WebElement radio_button_wanted; // Wanted

    @FindBy(id = "idpo")
    private WebElement checkbox_add_withPhotos; // Ads with photos

    @FindBy(id = "bList")         // to be continue!
    private WebElement listLocator_Make;  // Make

    @FindBy(id = "idprice1")
    private WebElement price_size_from; // Price

    @FindBy(id = "idprice2")
    private WebElement price_size_to; // Price

    @FindBy(id = "crc")               // to be continue!
    private WebElement listLocator_Currency;  // Currency

    @FindBy(id = "idcnd0")
    private WebElement radio_button_condition_New; // Condition

    @FindBy(id = "idcnd1")
    private WebElement radio_button_condition_Used; // Condition

    @FindBy(id = "locList")           // to be continue!
    private WebElement listLocator_Location;  //Location

    @FindBy(className = "hdr")
    private WebElement phones_found_result;     // when phones founded

    @FindBy(className = "notfound")
    private WebElement nothing_found;           // when nothing find


    public PhoneCategoryPage() {
        super();
    }
    @Override
    protected void load() {
        getDriver().get(PHONE_PAGE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("ElectronicsCategoryPage is not loaded!", getDriver().getCurrentUrl().contains(PHONE_PAGE_URL));
    }

        // Who are we dealing with
    public void choose_private() {
        waitForElementToBeClickable(getDriver(), radio_button_private);
        if (!radio_button_private.isSelected())
            radio_button_private.click();
    }

    // Who are we dealing with
    public void choose_organization() {
        waitForElementToBeClickable(getDriver(), radio_button_organization);
        if (!radio_button_organization.isSelected())
            radio_button_organization.click();
    }

    // For Sale
    public void choose_ForSale() {
        waitForElementToBeClickable(getDriver(), radio_button_forSale);
        if (!radio_button_forSale.isSelected())
            radio_button_forSale.click();
    }

    // Exchange
    public void choose_Exchange() {
        waitForElementToBeClickable(getDriver(), radio_button_exchange);
        if (!radio_button_exchange.isSelected())
            radio_button_exchange.click();
    }

    // Wanted
    public void choose_Wanted() {
        waitForElementToBeClickable(getDriver(), radio_button_wanted);
        if (!radio_button_wanted.isSelected())
            radio_button_wanted.click();
    }

    // Ads with photos
    public void choose_checkBox_WithPhotos() {
        waitForElementToBeClickable(getDriver(), checkbox_add_withPhotos);
        if (!checkbox_add_withPhotos.isSelected())
            checkbox_add_withPhotos.click();
    }

    // Make
    public void set_manufacturer_choice (String brandName) {
        waitForVisibilityOfElement(getDriver(), listLocator_Make);
        Select making = new Select(listLocator_Make);
        making.selectByVisibleText(brandName);
    }

    //Price Size - min
    public void set_price_sizeFrom (String price) {
        waitForVisibilityOfElement(getDriver(), price_size_from);
        price_size_from.sendKeys(price);
    }

    //Price Size - max
    public void set_price_sizeTo (String price) {
        waitForVisibilityOfElement(getDriver(), price_size_to);
        price_size_to.sendKeys(price);
    }

    //Currency
    public void set_currency_selection (int index) {
        waitForVisibilityOfElement(getDriver(), listLocator_Currency);
        Select currency = new Select(listLocator_Currency);
        currency.selectByIndex(index);

    }

    // Condition
    public void choose_conditionNew() {
        waitForElementToBeClickable(getDriver(), radio_button_condition_New);
        if (!radio_button_condition_New.isSelected())
        radio_button_condition_New.click();
    }

    // Condition
    public void choose_conditionUsed() {
        waitForElementToBeClickable(getDriver(), radio_button_condition_Used);
        if (!radio_button_condition_Used.isSelected())
            radio_button_condition_Used.click();
    }

    //Location
    public void set_location(String locName){
        waitForVisibilityOfElement(getDriver(), listLocator_Location);
        Select location = new Select(listLocator_Location);
        location.selectByVisibleText(locName);
    }

    public Boolean phone_found() {
        return phones_found_result.isDisplayed();
    }

    public Boolean nothing_found() {
        return nothing_found.isDisplayed();
    }

}
