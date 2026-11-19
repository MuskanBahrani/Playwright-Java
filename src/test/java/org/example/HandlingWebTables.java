package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

import java.util.List;


@UsePlaywright(CustomConfig.class)
public class HandlingWebTables {

    @Test
    public void handlingWebTables(Page page) {

        page.navigate("https://assertqa.com/practice/webtables");

        Locator row = page.locator("table#employees-table tr");
//        Locator johnRow = row.locator(":scope" , new Locator.LocatorOptions().setHasText("john.smith@company.com"));
//        System.out.println(johnRow.textContent());

        List<String> data = row.allTextContents();
        System.out.println(data);

    }
}
