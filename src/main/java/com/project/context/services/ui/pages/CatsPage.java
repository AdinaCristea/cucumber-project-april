package com.project.context.services.ui.pages;

import com.project.context.services.ui.general.BasePage;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@ScenarioScoped
public class CatsPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'FL-DSH-01')]")
    private WebElement manxCats;

    @FindBy(xpath = "//a[contains(text(),'FL-DLH-02')]")
    private WebElement persianCat;

    public void goToManxCatInStore() {
        manxCats.click();
    }


}
