package com.list.am_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertTrue;
import static com.list.am_automation.helpers.DriverHelper.getDriver;


public class ElectronicsCategoryPage extends BasePage <ElectronicsCategoryPage> {

    public static final String ELECTRONIC_PAGE_URL = "https://www.list.am/category/4";

    @FindBy(css = "a[href $= \"y/11\"]")
    private WebElement phone_category_button;

    public ElectronicsCategoryPage() {
        super();
    }

    @Override
    protected void load() {
        getDriver().get(ELECTRONIC_PAGE_URL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("ElectronicsCategoryPage is not loaded!", getDriver().getCurrentUrl().contains(ELECTRONIC_PAGE_URL));
    }

    public PhoneCategoryPage choose_phone_category () {
        phone_category_button.click();
        return new PhoneCategoryPage();
    }
}
