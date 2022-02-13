Feature: SignUp to Google Account
  Scenario Outline: SignUp to google with invalid password
    Given user visit to google signup page
    When user input less than eight character "<password>"
    Then user cannot signup
    Examples:
      | password |
      | 123      |
      | abcdef   |
      | abcd2#   |

  Scenario Outline: SignUp to google with invalid password
    Given user visit to google signup page
    When user input "<weak_password>"
    Then user cannot signup again
    Examples:
      | weak_password |
      | 12345678      |
      | abcdefgh      |
      | novel123      |
