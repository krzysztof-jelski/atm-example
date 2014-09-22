@wip
Feature: Cash Withdrawal

  Scenario: Successful withdrawal from an account
    Given my account has been credited with $100
    When I withdraw $20
    Then $20 should be dispensed
    And the balance of my account should be $80

  Scenario: User tries to withdraw more than their balance
    Given my account has been credited with $150
    When I withdraw $200
    Then nothing should be dispensed
    And I should be told that I have insufficient funds in my account
    And the balance of my account should be $150
	
  Scenario: User checks balance
    Given my account has been credited with $109
    When I check my balance
    Then balance displayed is $109
    
  Scenario: User checks his account balance
    Given my account has been credited with $123
    When I check account balance
    Then the balance $123 is displayed
    