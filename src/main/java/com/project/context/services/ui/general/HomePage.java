package com.project.context.services.ui.general;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@ScenarioScoped
public class HomePage extends BasePage {

    @FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
    private WebElement fishPage;

    @FindBy(xpath = "//img[@src='../images/cats_icon.gif']")
    private WebElement catsPage;

    public void goToFishPage() {
        fishPage.click();
    }

    public void goToCatsPage() {
        catsPage.click();
    }

}
