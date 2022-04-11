package com.project.context.services.ui.pages;

import com.project.context.services.ui.general.BasePage;
import io.cucumber.guice.ScenarioScoped;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.project.context.hook.UIInit.WEB_DRIVER_THREAD_LOCAL;

@ScenarioScoped
public class ShoppingCart extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Return to Main Menu')]")
    private WebElement returnToMainMenu;

    @FindBy(xpath = "//a[contains(text(),'Return to Main Menu')]")
    private WebElement mySelection;

    @FindBy(css = "a[href='/actions/Cart.action?removeItemFromCart=&workingItemId=EST-14']")
    private WebElement removeItemTaillessMaxBtn;

    @FindBy(linkText = "a[href='/actions/Cart.action?removeItemFromCart=&workingItemId=EST-15']")
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

    public void assertNotFound() {

        String taillessManx = WEB_DRIVER_THREAD_LOCAL.get().findElement(By.xpath(".//td[contains(text(),'Tailless')]")).getText();
        Assertions.assertNotSame(taillessManx, "Tailless Manx");
    }


    public void removeItem() {
        JavascriptExecutor executor = (JavascriptExecutor) WEB_DRIVER_THREAD_LOCAL.get();
        executor.executeScript("arguments[0].click()", removeItemTaillessMaxBtn);
//        removeItemTaillessMaxBtn.click();
    }


//    public void assertShoppingCartChanges() {
//        String confirmation2=WEB_DRIVER_THREAD_LOCAL.get().findElement(By.xpath(".//tr[3]/td[3]")).getText();
//        confirmation2.equalsIgnoreCase("With tail Manx");
//    }
}
