package com.project.context.services.ui.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.project.context.hook.UIInit.WEB_DRIVER_THREAD_LOCAL;

public class BasePage {

    protected WebDriver driver;

    //the other constructor is called [ TBA]
    protected BasePage() {
        this(WEB_DRIVER_THREAD_LOCAL.get());
    }

    //context
    protected BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
