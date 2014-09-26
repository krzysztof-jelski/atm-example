Feature: Banknotes are dispensed in a smart way

  @wip
  Scenario: Single banknote matches amount
    Given Atm has banknotes:
      | value   | count |
      | $100.00 | 1     |
      | $50.00  | 1     |
      | $20.00  | 3     |
    When $100 is to be dispensed
    Then following banknotes are dispensed:
      | value | count |
      | $100  | 1     |

  Scenario: Two banknotes match amount
    Given Atm has banknotes:
      | value | count |
      | $50   | 2     |
    When $100 is to be dispensed
    Then following banknotes are dispensed:
      | value | count |
      | $50   | 2     |
			