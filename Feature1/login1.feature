Feature: Login to the EMS application

  Background: 
    Given user navigates to the chrome browser
    And user enter the url "http://127.0.0.1:8282/ems"

  @first
  Scenario Outline: Login successful with valid credentials
    Given user enters valid username "<username>" and password "<password>"
    When user clicks on the login button
    Then login is successful

    Examples: 
      | username | password    |
      | admin    | admin123    |
      | admin1   | admin123    |
      | operator | operator123 |
