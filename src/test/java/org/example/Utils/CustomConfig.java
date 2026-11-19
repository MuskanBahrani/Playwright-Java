package org.example.Utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

public class CustomConfig implements OptionsFactory {

@Override
    public Options getOptions(){
    return new Options()
            .setHeadless(false)
            .setBrowserName("chromium");

}


}
