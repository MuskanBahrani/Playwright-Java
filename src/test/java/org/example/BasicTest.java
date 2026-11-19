package org.example;

import com.microsoft.playwright.*;

public class BasicTest {

    public static void main(String[] args){

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.flipkart.com");

        System.out.println(page.title());

        System.out.println(page.url());

        browser.close();
        playwright.close();
    }
}
