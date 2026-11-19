package org.example;

import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;
import com.microsoft.playwright.*;

import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

@UsePlaywright(CustomConfig.class)
public class TraceViewerTest {

    @Test
    void test(Page page) {

            page.context().tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

        page.navigate("https://www.amazon.in/");
        page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Amazon.in")).click();
        page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Amazon.in")).fill("mixer grinder");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go").setExact(true)).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apply the filter PHILIPS to")).click();
        page.locator("#a-autoid-39").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Add to cart")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Go to Cart")).click();


            page.context().tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
    }


}


