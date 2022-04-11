package com.project.context.hook;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

import static com.project.context.hook.UIInit.WEB_DRIVERS;
import static com.project.context.steps.BaseScenario.LOG;

@ScenarioScoped
public class UICleanup {

    @After(value = "@ui")
    public static void closeWebDrivers() {
        LOG.info("Closing {} webdriver", WEB_DRIVERS.size());
        {
            WEB_DRIVERS.forEach(WebDriver::quit);
        }
    }
}
