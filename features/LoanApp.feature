Feature: Freddie Loan Delivery System App
  As a Freddie Mac Client
  I want to submit loan application
  So that I can receive a quote

  Scenario: client fills out the LDSS form
    Given Freddie logs into to ldss
    When client enters loan information
    #filling out general loan info
    #click next to see loan terms
    #filling out loan Terms info
    Then client receives a confirmation
    And client receives a quote
