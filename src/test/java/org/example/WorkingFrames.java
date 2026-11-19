package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import org.example.Utils.CustomConfig;
import org.junit.jupiter.api.Test;

@UsePlaywright(CustomConfig.class)
public class WorkingFrames {


    @Test
    public void test(Page page){

        page.navigate("https://demoqa.com/nestedframes");

        FrameLocator parent = page.frameLocator("//iframe[@id='frame1']");
        String parentFrameName = parent.locator("body").textContent();
        System.out.println(parentFrameName);


        FrameLocator childFrame = parent.frameLocator("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]");
        String childFrameName = childFrame.locator("body p").textContent();
        System.out.println(childFrameName);

    }

}
