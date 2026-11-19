package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;


@UsePlaywright(CustomConfig.class)
public class FileUploadTest {

    @Test
    public void testUpload(Page page) throws InterruptedException {

        page.navigate("https://automationtesting.co.uk/fileupload.html");

        page.setInputFiles("#fileToUpload" , Paths.get("upload.txt"));
        Thread.sleep(5000);

    }
}
