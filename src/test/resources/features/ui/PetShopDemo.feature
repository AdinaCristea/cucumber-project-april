@ui
Feature: Homework UI  - UI test

  Scenario: Pet-shop demo store - actions

    When [UI] Go to cats pet page
    And [UI] See manx cats in store
    Then [UI] Add to cart one Tailless Manx
    Given [UI] Return to main menu
    And [UI] Go to cats pet page
    And [UI] See manx cats in store
    And [UI] Add to cart one With tale Manx
    Then [UI] Assert that products are added to cart
    Given [UI] Remove item
    Then [UI] Assert product is removed from cart
    And [UI] Remove second item
    Then [UI] Assert all products are removed from cart
    # Following remove item will fail due to previous assert - as expected
    Then [UI] Remove item

