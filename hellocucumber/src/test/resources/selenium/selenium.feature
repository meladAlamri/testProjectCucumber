Feature: selenium test

  Scenario: My first real scenario
    Given my browser is open
    When I navigate to google
    And I search for selenium webdriver
    Then result should not be emitter