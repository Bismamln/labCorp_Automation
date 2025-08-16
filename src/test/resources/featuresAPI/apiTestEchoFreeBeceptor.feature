Feature: Echo Free Beeceptor API Tests
  As a user I want to verify APIs for Echo Free Beeceptor.

  Scenario: Verify the get response json schema for Echo Free Beeceptor API
    Given User fetch the beeceptor API base URI
    And  query params for property as "author" and value as "beeceptor"
    When User Send the "GET" request with endpoint as "sample-request"
    Then Verify the status code to be 200
    #And Validate the json schema of "getEchoFreeBeceptorSchema.txt"


Scenario: Verify the post response for Echo Free Beeceptor API
    Given User fetch the beeceptor API base URI
    And  query params for property as "author" and value as "beeceptor"
    And get request body as "getEchoFreeBeceptor.json"
    When User Send the "POST" request with endpoint as "sample-request"
    Then Verify the status code to be 200
    And Validate the response context
      | jsonPath                            | Value                 |
      | parsedBody.customer.name          | Jane Smith            |
      | parsedBody.customer.email         | janesmith@example.com |
      | parsedBody.customer.address.city | Metropolis            |
    
    