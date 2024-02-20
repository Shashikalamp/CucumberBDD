Feature :Verify that the new user registration is successful after passing correct input

 Scenario : Enter user registration all details with valid credentials
  Given : User navigate to the registration page
  When : User enter valid data on the page
  |Field|Values|
  |Username | shashi|
  |Password|shashi@12|
  |Confirm password|shashi@12|
  |Birth date |01|
 Then : User registration should be successfully
