package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;


@UsePlaywright(CustomConfig.class)
public class AutoLoginTrial {

    @Test
    public void testAutoLogin(Browser browser){

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("login.json")));
        Page page = browser.newPage();

        page.navigate("https://bstackdemo.com/signin");
    }
}
