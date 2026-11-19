package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

@UsePlaywright(CustomConfig.class)
public class AutoLoginRecording {

    @Test
    public void testAutoLoginRecording(BrowserContext browserContext){

        Page page = browserContext.newPage();

        page.navigate("https://bstackdemo.com/signin");
        page.locator("div#username").click();
        page.locator("div:has-text('demouser')").first().click();

        page.locator("div#password").click();
        page.locator("div:has-text('testingisfun99')").first().click();

        page.locator("#login-btn").click();

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("login.json")));



    }
}
