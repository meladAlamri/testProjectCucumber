#Breakout Task: 45 minutes
#Optimize your feature file (background, scenario outline, examples, tags) to search for multiple queries
#Optimize your step def file to use hooks
#Optimize your test runner to show the cucumber.html report
#EXTRA: upgrade your code to implement the Page Object Model

 #Breakout Assignment (45 minutes)
 #refactor your project to implement the POM pattern
 #Extra 1: refactor to implement fluent POM
 #Extra 2: implement Allure Reporting
Feature: selenium test

  Background:
    Given my browser is open

  Scenario Outline: Google search
    When I navigate to google
    And I search for "<search>"
    Then result should not be emitter

    Scenarios:
      | search                |
      | Google                |
      | Amazon                |
      | YouTube               |
      | selenium webdriver    |
      | Saudi Digital Academy |

    @Search
    Scenarios:
      | search             |
      | selenium webdriver |


  @example
  Scenario: Google search
    When I search for something
    Then result should not be emitter