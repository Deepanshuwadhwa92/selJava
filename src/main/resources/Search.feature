Feature: Outline test

  Scenario Outline: Search <homepage> Scenario

    Given The User is navigate to "<homepage>" Home page
    And The User enter "<searchword>" on "<homepage>" Search page
    And The User press Enter Key on "<homepage>" Search page
    Then The User can see the results in "<homepage>" Home page

    Examples:
      | homepage | searchword |
      | google   | kanmani    |
      | yahoo    | Tamil      |
      | google   | kanmani    |
      | yahoo    | Tamil      |
      | google   | kanmani    |
      | yahoo    | Tamil      |