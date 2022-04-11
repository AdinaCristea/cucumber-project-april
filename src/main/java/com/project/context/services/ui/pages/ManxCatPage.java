package com.project.context.services.ui.pages;

import com.project.context.services.ui.general.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManxCatPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'EST-14')]")
    private WebElement taillessManx;

    @FindBy(xpath = "//a[contains(text(),'EST-15')]")
    private WebElement withTailManx;

    @FindBy(xpath = "//a[@href='/actions/Cart.action?addItemToCart=&workingItemId=EST-14']")
    private WebElement addToCardTaillessManxBtn;

    @FindBy(xpath = "//tr[3]/td[5]/a")
    private WebElement addToCardWithTailMaxBtn;

    public void addToCartTaillessManx() {
        addToCardTaillessManxBtn.click();
    }

    public void addToCartWithTailManx() {
        addToCardWithTailMaxBtn.click();
    }
}
