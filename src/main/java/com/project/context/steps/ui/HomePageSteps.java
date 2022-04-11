package com.project.context.steps.ui;

import com.google.inject.Inject;
import com.project.context.services.ui.general.HomePage;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;

@ScenarioScoped
public class HomePageSteps {

    //logger
    //injection
    @Inject
    private HomePage homePage;

    @Given("[UI] Go to fish pet page")
    public void goToFishPage() {
        homePage.goToFishPage();
    }

    @Given("[UI] Go to cats pet page")
    public void goToCatsPage() {
        homePage.goToCatsPage();
    }

}
