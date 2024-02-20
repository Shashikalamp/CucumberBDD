Feature: User Navigation and Verification

  Background: 
    Given user launch the chrome browser
    When user navigate to the URL "http://127.0.0.1:8282/ems"
    Given user enter the username "<username>" and password "<password>"
    And click on the login button
    Then login is successfully

  @AQI
  Scenario: Check whether AQI button is clickable and navigate to Environment aqi page
    Given user on the dashboard page
    When user click on AQI button
    Then user can view the Environment aqi page
    When user click back button

  @AQI
  Scenario: Verify whether UI aqi value and Backend AQI value is same or not
    Given user navigate to dashboard aqi value page
    When user click on AQi button and get AQI value
    Then print the Ui AQI value
    When user get the AQI value from backend server using shellscript
    And compare the UI AQI value with Server AQI value
    Then print Both Ui and server AQI value is matched or not

  @Weather
  Scenario: Check whether Weather button is clickable and navigate to Environment weather page
    Given user on the dashboard weather page
    When user click on Weather button
    Then user can view the Environment weather page
    When user click back button

  @Weather
  Scenario: Verify whether UI weather value and Backend weather value is same or not
    Given user navigate to dashboard weather value page
    When user click on weather button and get weather value
    Then print the Ui weather value
    When user get the Weather value from backend server using shellscript
    And compare the UI Weather value with Server Weather value
    Then print Both Ui and server Weather value is matched or not

  @Station
  Scenario: Check whether Station button is clickable and navigate to Device page
    Given user on the station dashboard page
    When user click on Station button
    Then user can view the Device station page
    When user click on station back button
