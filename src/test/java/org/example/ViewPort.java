package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

@UsePlaywright(CustomConfig.class)
public class ViewPort {

    @Test
    public void test(Browser browser) throws Exception {

        BrowserContext cxt1 =  browser.newContext(new Browser.NewContextOptions().setViewportSize(500,500));
        Page page1 = cxt1.newPage();

        page1.navigate("https://www.amazon.in");
        Thread.sleep(5000);
    }
}
