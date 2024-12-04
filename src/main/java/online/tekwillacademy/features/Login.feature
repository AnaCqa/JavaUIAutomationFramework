Feature: Login related tests

  @run
  Scenario Outline: An error message is displayed when trying to log in with invalid details
    Given The "https://tekwillacademy-opencart.online/index.php?route=account/login&language=en-gb" is accessed
    And the login form is populated with the following data:
      | <email>    |
      | <password> |
    When the loginBtn is clicked
    Then the following list of error message is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | email            | password     |
      | email2@gmail.com | Password123! |
      | email1@gmail.com | !            |

