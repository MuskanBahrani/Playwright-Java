package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;
import java.util.*;


@UsePlaywright(CustomConfig.class)
public class DropDown {


    @Test
    public void dropDownTest(Page page){

        page.navigate("https://demoqa.com/select-menu");

        Locator dropDownOptions = page.locator("select#oldSelectMenu option");
        System.out.println(dropDownOptions.count());

        // using list
        List<String> values = dropDownOptions.allTextContents();
        for(String str : values){
            System.out.println(str);
        }


        System.out.println("***************************");

        // printing using index

        for(int i=0;i<dropDownOptions.count();i++){
            System.out.println(dropDownOptions.nth(i).textContent());
        }
    }

}
