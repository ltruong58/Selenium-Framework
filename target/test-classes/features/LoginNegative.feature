@Login
Feature: User Not able to successfully log in to Connect

  @smoke
  Scenario Outline: User Not able to log in successfully
    When I enters email "<username>"
    And I click log in button
    And I enter password "<password>"
    And I click log in button
    Then I verify the Invalid username or password.

    Examples:
      | username | password |
      | max.muerzati | Password135 |

