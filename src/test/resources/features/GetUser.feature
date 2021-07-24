@get
Feature: GET user api feature
  As a system user
  I want to GET user details

  Scenario Outline: Verify GET request for single user using userId
    Given Go rest api is up and running
    When I perform GET request with endpoint as "/public/v1/users/{user_id}" for "<userId>"
    Then I should receive response with status code as 200
    And I should receive details for same <userId>
    Examples:
      | userId |
      | 15     |
      | 16     |
      | 17     |


  Scenario: Verify GET request for invalid userId
    Given Go rest api is up and running
    When I perform GET request with endpoint as "/public/v1/users/{user_id}" for 788996
    Then I should receive response with status code as 404
    And I should receive the Error Response as "Resource not found"