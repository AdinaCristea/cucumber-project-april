package com.project.context.steps.ui;

import com.google.inject.Inject;
import com.project.context.services.ui.pages.ManxCatPage;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;

@ScenarioScoped
public class ManxCatPageSteps {

    @Inject
    private ManxCatPage manxCatPage;

    @Then("[UI] Add to cart one Tailless Manx")
    public void addToCartTaillessManx() {
        manxCatPage.addToCartTaillessManx();
    }

    @Then("[UI] Add to cart one With tale Manx")
    public void addToCartWithTailManx() {
        manxCatPage.addToCartWithTailManx();
    }
}
