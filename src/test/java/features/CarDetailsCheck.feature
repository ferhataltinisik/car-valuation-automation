Feature: Car Valuation Check

  Scenario: Validate all car registration details from input file
    Given I have a file named "car_input.txt" with vehicle registration numbers
    And I am on the home page
    When I search each vehicle registration on car valuation website
    Then I should see all vehicle details matched correctly
