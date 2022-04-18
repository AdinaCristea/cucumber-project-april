package com.project.context.services.ui.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.project.context.hook.UIInit.WEB_DRIVER_THREAD_LOCAL;

public class BasePage {

    protected WebDriver driver;

    // will instantiate page
    
    protected BasePage() {
        this(WEB_DRIVER_THREAD_LOCAL.get());
    }

    // @find by, elements will be ready because to be use
    
    protected BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
