Feature: Labcorp Career Navigation
  As a user I should able to Navigate to Career Page in LabCorp.

  Scenario: I login with valid credential
    Given I navigate to "https://www.labcorp.com/"
    And I clicks on Careers link
    And Search the job with "IT Product Manager"
    And Click to Search a job
    When Click on the job
    Then Verify the Job should contains following details
      | Field             | Value                                                    |
      | Job Title         | IT Product Manager                                       |
      | Location          | LocationDurham, North Carolina, United States of America |
      | Job Id            | Job ID : 2516837                                         |
      | Minimum Education | Bachelor’s degree required                               |
    
    