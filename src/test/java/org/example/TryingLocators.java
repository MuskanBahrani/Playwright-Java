package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

@UsePlaywright(CustomConfig.class)
public class TryingLocators {

    //RTLPATTCX -> Role,Text,Label,Placeholder,Alternative text,Title,TestID,CSS,Xpath

    @Test
    public void TryingLocatorsTest(Browser browser) {

        BrowserContext cxt1 = browser.newContext();
        Page page = cxt1.newPage();

        page.navigate("https://demoqa.com/text-box");

        page.locator("id=userName").fill("John Doe"); //id

        page.getByPlaceholder("name@example.com").fill("johndoe234@gmail.com"); //placeholder

//CSS
        page.locator("textarea.form-control").first().fill("This is a demo current address");
//ID and CSS
        page.locator("#permanentAddress").fill("This is a demo permanent address");
// Role
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();

        Page page1 = cxt1.newPage();
        page1.navigate("https://demoqa.com/buttons");

        //text

        page1.getByText("Click Me").last().click();
        page1.reload();

        page1.locator("text=Click Me").last().click();
        page1.reload();

        page1.locator("button:has-text('Click Me')").nth(2).click();

        Page page2 = cxt1.newPage();
        page2.navigate("https://demoqa.com/text-box");

        //label

//        String fullNameLabel  = page2.getByLabel("Full Name").textContent();
//        System.out.println(fullNameLabel);

     //alt text
        //page.getByAltText()

        //page.getByTitle()
        //page.getByTestID()

        //xpath
        Locator lct = page2.locator("//div/textarea[@id='permanentAddress']");
        lct.fill("Permanent address");

        String value = lct.inputValue();
        System.out.println(value);

    }




}
