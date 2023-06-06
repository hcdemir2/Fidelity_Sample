@regression @homePage
Feature: As a public user, I should be able to navigate using home page menu items

  Background: Public user is on the home page
    Given public user is on the home page

  Scenario Outline: Menu Items should expand with mouse hover action
    And user hovers over "<header>" header
    Then user should see "<menu_item>" menu item
    Examples:
      | header            | menu_item              |
      | Accounts & Trade  | Portfolio              |
      | Planning & Advice | What We Offer          |
      | News & Research   | News                   |
      | Products          | Mutual Funds           |
      | Why Fidelity      | The Fidelity Advantage |