@Login
Feature: User able to successfully log in to Connect

  @smoke
  Scenario Outline: User able to log in successfully
    When I enters email "<username>"
    And I click log in button
    And I enter password "<password>"
    And I click log in button
    And I test if this work
    And test "<param>"
    Then I verify the home page

    Examples:
      | username | password |
      |abc       |test                        |
      | kaka1508 | RV30SQqI0IIdev2ak8LrFHSgX6 |