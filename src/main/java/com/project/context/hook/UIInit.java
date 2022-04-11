package com.project.context.hook;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ScenarioScoped
public class UIInit {

    public static final Set<WebDriver> WEB_DRIVERS = Collections.synchronizedSet(new HashSet<>());
    public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);

    @Before(value = "@ui")
    public void WebDriver() throws MalformedURLException {
        WebDriver driver = WEB_DRIVER_THREAD_LOCAL.get();
        if (driver == null) {
            driver = getFirefoxWebdriver();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
            WEB_DRIVER_THREAD_LOCAL.set(driver);
            WEB_DRIVERS.add(driver);
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    }

    private static WebDriver getFirefoxWebdriver() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        return new RemoteWebDriver(new URL("http://localhost:4444"), options);

    }
}
