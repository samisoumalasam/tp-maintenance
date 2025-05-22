Feature: Bar
    Background: Basic context
        Given Mr. Pignon and Mr. Leblanc go to a cocktail bar
        And the bar has only 10 seats

    Scenario: They are refused because the bar is almost full
        Given there are already 9 people in the bar
        When Mr. Pignon and Mr. Leblanc arrive
        Then they should be refused entry

    Scenario: They get in, order cocktails, and Mr. Leblanc pays
        Given there are already 8 people in the bar
        When Mr. Pignon and Mr. Leblanc arrive
        Then they are allowed in
        And the bar becomes full

        When they each order a cocktail of the month costing 10€
        And Mr. Leblanc decides to pay for both
        Then the total bill should be 20€
        And Mr. Leblanc should pay 20€
        And Mr. Pignon should pay 0€

        When they pay the bill
        Then Mr. Leblanc should have paid 20€
        And Mr. Pignon should have paid 0€
        And Mr. Pignon should be happy

    Scenario: They get in, order cocktails twice, and Mr. Pignon regrets it
        Given there are already 3 people in the bar
        When Mr. Pignon and Mr. Leblanc arrive
        Then they are allowed in
        And the bar should have 5 seats remaining

        When they each order a cocktail of the month costing 10€
        And no one pays for the other
        Then the total bill should be 20€
        And Mr. Leblanc should pay 10€
        And Mr. Pignon should pay 10€

        When Mr. Pignon pays his part
        Then Mr. Leblanc should have paid 0€
        And Mr. Pignon should have paid 10€
        And the remaining bill should be 10€

        When Mr. Leblanc orders two more cocktails of the month
        And he decides to pay for both
        Then the total bill should be 30€
        And Mr. Leblanc should pay 30€
        And Mr. Pignon should pay 0€

        When the bill is paid
        Then Mr. Leblanc should have paid 30€
        And Mr. Pignon should have paid 10€
        And Mr. Pignon should be sad
