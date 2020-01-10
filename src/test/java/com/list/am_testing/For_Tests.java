package com.list.am_testing;

import com.list.am_automation.pages.ElectronicsCategoryPage;
import com.list.am_automation.pages.HomePage;
import com.list.am_automation.pages.PhoneCategoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

// 1. Use the following data for the set_manufacturer_choice() method
//    Acer, Alcatel, Apple iPhone, Fly, Samsung, Xiaomi, Other.

// 2. Use the following data for the set_currency_selection() method
//    index 0 = All, index 1 = AMD, index 2 = USD.

// 3. Use the following data for the set_location() method
//    Yerevan, Aragatsotn, Ararat, Armavir, Kotayk, Lorri, Shirak, Syunik.

public class For_Tests extends BaseTest {

    @Test(priority = 1)
    public void firstTest() {
        HomePage homePage = new HomePage();
        homePage.get();

        ElectronicsCategoryPage electronics_page = homePage.choose_el_category();
        electronics_page.get();

        PhoneCategoryPage phone_Page = electronics_page.choose_phone_category();
        phone_Page.get();

        phone_Page.choose_private();
        phone_Page.choose_ForSale();
        phone_Page.set_manufacturer_choice("Samsung");
        phone_Page.set_currency_selection(1);
        phone_Page.set_price_sizeFrom("30000");
        phone_Page.set_price_sizeTo("180000");
        phone_Page.choose_conditionUsed();
        scrollPage();
        phone_Page.set_location("Shirak");

        Assert.assertTrue(phone_Page.phone_found());

    }


    @Test(priority = 2)
    public void secondTest() {

        HomePage homePage = new HomePage();
        homePage.get();

        ElectronicsCategoryPage electronics_page = homePage.choose_el_category();
        electronics_page.get();

        PhoneCategoryPage phone_Page = electronics_page.choose_phone_category();
        phone_Page.get();

        phone_Page.choose_organization();
        phone_Page.choose_Exchange();
        phone_Page.set_manufacturer_choice("Apple iPhone");
        phone_Page.set_currency_selection(0);
        phone_Page.set_price_sizeTo("35");
        phone_Page.choose_conditionNew();
        phone_Page.set_location("Yerevan");

        Assert.assertTrue(phone_Page.nothing_found());

    }
}
