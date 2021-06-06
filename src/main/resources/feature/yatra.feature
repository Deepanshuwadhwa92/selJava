# Created by jidma at 30/05/2021
Feature: Search for a particular destination
  # Enter feature description here

  Scenario Outline: Select the destination from the list

    Given The User is in yatra WebSite Page
    And The User click on destination field on yatra WebSite Page
    And The User click on the destination "<places>" in the yatra WebSite Page
    Then The User can see that the destination is added to the Destination "<destCode>" in the yatra WebSite Page

    Examples:
      | places    | destCode |
      | Chennai   | MApA      |
      | Jaipur    | JAI      |
      | Goa       | GOI      |
      | Bangalore | BLR      |
      | Pune      | PNQ      |
