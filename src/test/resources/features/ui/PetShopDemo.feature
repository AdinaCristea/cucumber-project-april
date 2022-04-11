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
    # Remove items item
    Given [UI] Remove item
#    Then [UI] Assert product is removed from cart
#    And [UI] Remove item
##    Then [UI] Assert product is removed from cart
#    Then [UI] Remove item

