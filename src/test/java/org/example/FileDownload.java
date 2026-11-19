package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;


@UsePlaywright(CustomConfig.class)
public class FileDownload {

    @Test
    public void testDownload(Page page) throws InterruptedException {

        page.navigate("https://demoqa.com/upload-download");

        Download dl = page.waitForDownload(() -> {
            page.locator("a:has-text('Download')").last().click();
        });

        dl.saveAs(Paths.get("Download"));
    }
}
