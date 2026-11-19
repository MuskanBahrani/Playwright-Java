package org.example;

import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.*;
import org.example.Utils.CustomConfig;

@UsePlaywright(CustomConfig.class)
public class RecordedTest {


        @Test
        void test(Page page) {

            page.navigate("https://www.amazon.in/");
            page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Amazon.in")).click();
            page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Amazon.in")).fill("mobile phones");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go").setExact(true)).click();
            page.locator("#a-autoid-14 > .a-button-inner > .a-button-input").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Go to Cart")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Increase quantity by one,")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed to Buy Buy Amazon")).click();

        }
    }

