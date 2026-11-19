package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;


@UsePlaywright(CustomConfig.class)
public class NewTabHandling {

    @Test
    public void Test(Page page){

        page.navigate("https://demoqa.com/browser-windows");

       Page newPage =  page.waitForPopup(() -> {
            page.click("#tabButton");
        });

        System.out.println(newPage.url());
        newPage.close();

        System.out.println(page.title());


        //opening a blank tab

        Page blankPage = page.waitForPopup(() -> {
            page.click("a[target='_blank']");
        });
        blankPage.waitForLoadState();
        blankPage.navigate("https://demoqa.com");

        System.out.println(blankPage.url());


    }
}
