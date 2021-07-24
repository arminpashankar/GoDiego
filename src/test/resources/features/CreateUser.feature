@post
Feature: Create user feature
  As an authenticated user
  I want to create a user

  Scenario: Check create user functionality
    Given user is authorized
    | Authorization | Bearer e89432f1729235a2d7db31e35ef8142bcdd8ccc2a71b759dc76ef9891f14d746 |
    When user make post request with endpoint as "/public/v1/users"
    Then user should get response with status code as 201
    When user make GET request to verify user details with endpoint as "/public/v1/users/{userId}"
    Then user should get response with status code as 200
    And user should receive response for same user
