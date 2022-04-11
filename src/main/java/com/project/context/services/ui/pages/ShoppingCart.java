package com.project.context.services.ui.pages;

import com.project.context.services.ui.general.BasePage;
import io.cucumber.guice.ScenarioScoped;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.project.context.hook.UIInit.WEB_DRIVER_THREAD_LOCAL;

@ScenarioScoped
public class ShoppingCart extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Return to Main Menu')]")
    private WebElement returnToMainMenu;

    @FindBy(xpath = "//a[contains(text(),'Return to Main Menu')]")
    private WebElement mySelection;

    @FindBy(css = "a[href='/actions/Cart.action?removeItemFromCart=&workingItemId=EST-14']")
    private WebElement removeItemTaillessMaxBtn;

    @FindBy(css = "a[href='/actions/Cart.action?removeItemFromCart=&workingItemId=EST-15']")
    private WebElement removeItemWIthTailBtn;


    public void returnToMainMenu() {
        returnToMainMenu.click();
    }

    public void assertsInCart() {
        String taillessManx = WEB_DRIVER_THREAD_LOCAL.get().findElement(By.xpath(".//td[contains(text(),'Tailless')]")).getText();
        String withThailManx = WEB_DRIVER_THREAD_LOCAL.get().findElement(By.xpath(".//td[contains(text(),'With')]")).getText();
        Assertions.assertEquals(taillessManx, "Tailless Manx");
        Assertions.assertEquals(withThailManx, "With tail Manx");
    }

    public void removeItem() {
        JavascriptExecutor executor = (JavascriptExecutor) WEB_DRIVER_THREAD_LOCAL.get();
        executor.executeScript("arguments[0].click()", removeItemTaillessMaxBtn);
    }


    public void removeSecondItem() {
        JavascriptExecutor executor = (JavascriptExecutor) WEB_DRIVER_THREAD_LOCAL.get();
        executor.executeScript("arguments[0].click()", removeItemWIthTailBtn);
    }

    public boolean getInvisibilityOfElement() {
        return new WebDriverWait(WEB_DRIVER_THREAD_LOCAL.get(), Duration.ofSeconds(20))
                .until(
                        ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated
                                (By.xpath(".//td[contains(text(),'Tailless')]"), "Tailless"))
                );
    }

    public boolean getInvisibilityOfElements() {
        return new WebDriverWait(WEB_DRIVER_THREAD_LOCAL.get(), Duration.ofSeconds(20))
                .until(
                        ExpectedConditions.and(
                                ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//td[contains(text(),'Tailless')]")),
                                ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//td[contains(text(),'With')]")))
                );
    }

}

