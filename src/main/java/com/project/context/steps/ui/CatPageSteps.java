package com.project.context.steps.ui;

import com.google.inject.Inject;
import com.project.context.services.ui.pages.CatsPage;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.When;

@ScenarioScoped
public class CatPageSteps {
    @Inject
    private CatsPage catsPage;

    @When("[UI] See manx cats in store")
    public void goToManxCats() {
        catsPage.goToManxCatInStore();
    }
}
