package com.list.am_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertTrue;
import static com.list.am_automation.helpers.DriverHelper.getDriver;

public class HomePage extends BasePage <HomePage> {

    public static final String BASE_URL = "https://www.list.am/en/";

    @FindBy(css = "div[data-c = \"4\"]")
    private WebElement electronic_category_button;

    public HomePage() {
        super();
    }

    protected void load() {
        getDriver().get(BASE_URL);
    }

    protected void isLoaded() throws Error {
        assertTrue("HomePage is not loaded!", getDriver().getCurrentUrl().contains(BASE_URL));
    }

    public ElectronicsCategoryPage choose_el_category () {
        electronic_category_button.click();
        return new ElectronicsCategoryPage();
    }
}
