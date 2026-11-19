package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

@UsePlaywright(CustomConfig.class)
public class ComplexLocators {

    @Test
    public void test(Page page){

        page.navigate("https://www.amazon.in");

        // use has condition -> this is used when parent element does not have any solid attribute that can be used

        //page.locator("div.nav-div:has(a:has-text('Amazon Pay'))").click();
        //This means there a div with class nav-div and it has a anchor tag that has text Amazon Pay, this clicks on div not on a

        //This is xpath version of above code, we cannot use has(), has-text() with xpaths
        //page.locator("//div[@class='nav-div']/a[contains(text(),'Amazon Pay')]").click();

        // There are ways to use multiple locators in a single locator method
        // let's say I have touse CSS selectors to find an element but there are 2-3 good conditions that can be used so we use OR operator
        // OR is , for CSS and | for xpath

//        Locator check = page.locator("#twotabsearchtextbox , label:has-text('Search Amazon.in')");
//        System.out.println(check.count());
//
//
//        Locator check2 = page.locator("//input[@id='twotabsearchtextbox'] | //label[contains(text() , 'Search Amazon.in')]");
//        System.out.println(check2.count());
//
//        Locator check3 = page.locator("//input[@id='twotabsearchtextbox'][@placeholder='Search Amazon.in']");
//        System.out.println(check3.count());

        // using indexes with CSS locators >> nth=value
        Locator languageDropDown = page.locator("div#nav-flyout-icp ul li").nth(2);
        String language = languageDropDown.locator("a").getAttribute("lang");
        System.out.println(language);

    }
}
