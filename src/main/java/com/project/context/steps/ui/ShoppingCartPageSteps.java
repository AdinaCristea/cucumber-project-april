package com.project.context.steps.ui;

import com.google.inject.Inject;
import com.project.context.services.ui.pages.ShoppingCart;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;

@ScenarioScoped
public class ShoppingCartPageSteps {

    @Inject
    private ShoppingCart shoppingCart;

    @Then("[UI] Return to main menu")
    public void returnToMainMenu() {
        shoppingCart.returnToMainMenu();
    }

    @Then("[UI] Assert that products are added to cart")
    public void assertProducts() {
        shoppingCart.assertsInCart();
    }

    @Then("[UI] Assert product is removed from cart")
    public void assertNotFoundProduct() {
        shoppingCart.assertNotFound();
    }

    @Then("[UI] Remove item")
    public void removeItem() {
        shoppingCart.removeItem();
    }


}
