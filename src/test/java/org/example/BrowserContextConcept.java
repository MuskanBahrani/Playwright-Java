package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;


@UsePlaywright(CustomConfig.class)
public class BrowserContextConcept {

    @Test
    void testingContexts(Browser browser){
        BrowserContext cx1 = browser.newContext();
        Page page1 = cx1.newPage();

        page1.navigate("https://www.snapdeal.com/");
        System.out.println("Title of Page 1: " + page1.title());



        BrowserContext cx2 = browser.newContext();
        Page page2 = cx2.newPage();

        page2.navigate("https://www.flipkart.com/");
        System.out.println("Title of Page 2: " + page2.title());

        Page page3 = cx2.newPage();
        page3.navigate("https://www.myntra.com/");
        System.out.println("Title of Page 3: " + page3.title());
    }


}
