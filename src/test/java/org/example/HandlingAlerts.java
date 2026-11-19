package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;


@UsePlaywright(CustomConfig.class)
public class HandlingAlerts {

    @Test
    public void handlingJSAlerts(Page page) throws InterruptedException {

        // this is auto handling of Playwright


//        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
//
//        page.click("button:has-text('Click for JS Alert')");
//        System.out.println(page.locator("#result").textContent());
//        Thread.sleep(5000);
//
//        page.click("button:has-text('Click for JS Confirm')");
//        System.out.println(page.locator("#result").textContent());
//        Thread.sleep(5000);
//
//
//        page.click("button:has-text('Click for JS Prompt')");
//        System.out.println(page.locator("#result").textContent());
//        Thread.sleep(5000);

        // now if we have to handle via on dialog

        page.onDialog(dialog -> {
            String text = dialog.message();
            System.out.println(text);
            dialog.accept("This is for prompts");
        });

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        page.click("button:has-text('Click for JS Alert')");
        System.out.println(page.locator("#result").textContent());
        Thread.sleep(5000);

        page.click("button:has-text('Click for JS Confirm')");
        System.out.println(page.locator("#result").textContent());
        Thread.sleep(5000);


        page.click("button:has-text('Click for JS Prompt')");
        System.out.println(page.locator("#result").textContent());
        Thread.sleep(5000);



    }
}
