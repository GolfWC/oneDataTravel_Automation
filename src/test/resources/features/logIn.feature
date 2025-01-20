Feature: login Feature Demo

  @login
    Scenario: Login with valid credentials
      Given I am on the login page
      When I enter my username and password
      Then I should be logged in


@login
  Scenario: Login with Invalid credentials
    Given I am on the login page
    When I enter my username and password
    Then I should be logged in